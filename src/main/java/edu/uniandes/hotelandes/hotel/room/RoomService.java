package edu.uniandes.hotelandes.hotel.room;

import edu.uniandes.hotelandes.exception.NotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
  private final RoomDAO roomDAO;

  @Autowired
  public RoomService(RoomDAO roomDAO) {
    this.roomDAO = roomDAO;
  }

  public void createRoom(Room room) {
    // TODO: check RoomType exists
    final var rooms = roomDAO.selectRoomById(room.id());
    if (rooms.isEmpty()) {
      final var r = roomDAO.insertRoom(room);
      if (r != 1) {
        throw new IllegalStateException("Room creation went wrong");
      }
    } else {
      throw new IllegalStateException("Room already exists");
    }
  }

  public Room getRoom(Integer id) {
    return roomDAO
        .selectRoomById(id)
        .orElseThrow(() -> new NotFoundException(String.format("Room with id %s not found", id)));
  }

  public List<Room> getRooms() {
    return roomDAO.selectRooms();
  }

  public Room updateRoom(Integer id, Room room) {
    final var rooms = roomDAO.selectRoomById(room.id());
    if (rooms.isPresent()) {
      final var r = roomDAO.updateRoom(id, room);
      if (r != 1) {
        throw new IllegalStateException("Room creation went wrong");
      }
      return room;
    } else {
      throw new IllegalStateException("Room doesn't exists");
    }
  }

  public void deleteRoom(Integer id) {
    final var rooms = roomDAO.selectRoomById(id);
    rooms.ifPresentOrElse(
        room -> {
          final var result = roomDAO.deleteRoom(id);
          if (result != 1) {
            throw new IllegalStateException("Could not delete room");
          }
        },
        () -> {
          throw new NotFoundException(String.format("Room with id %s not found", id));
        });
  }
}
