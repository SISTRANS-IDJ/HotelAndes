package edu.uniandes.hotelandes.hotel.room.booking;

import edu.uniandes.hotelandes.exception.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomBookingService {
  private final RoomBookingDAO roomBookingDAO;

  @Autowired
  public RoomBookingService(RoomBookingDAO roomBookingDAO) {
    this.roomBookingDAO = roomBookingDAO;
  }

  public void createRoomBooking(RoomBooking roomBooking) {
    var id = UUID.randomUUID().toString();
    var roomBookingCreate =
        new RoomBooking(
            id,
            roomBooking.clientId(),
            roomBooking.hotelRoomId(),
            roomBooking.checkIn(),
            roomBooking.checkOut(),
            roomBooking.capacity(),
            roomBooking.consumptionPlanId());
    final var r = roomBookingDAO.insertRoomBooking(roomBookingCreate);
    if (r != 1) {
      throw new IllegalStateException("Room booking creation went wrong");
    }
  }

  public RoomBooking getRoomBooking(String id) {
    return roomBookingDAO
        .selectRoomBookingById(id)
        .orElseThrow(
            () ->
                new EntityNotFoundException(
                    String.format("Room booking with id %s not found", id)));
  }

  public List<RoomBooking> getRoomBookings() {
    return roomBookingDAO.selectRoomBookings();
  }

  public RoomBooking updateRoom(String id, RoomBooking roomBooking) {
    final var roomBookings = roomBookingDAO.selectRoomBookingById(roomBooking.id());
    if (roomBookings.isPresent()) {
      final var r = roomBookingDAO.updateRoomBooking(id, roomBooking);
      if (r != 1) {
        throw new IllegalStateException("Room booking update went wrong");
      }
      return roomBooking;
    } else {
      throw new IllegalStateException("Room booking doesn't exists");
    }
  }

  public void deleteRoom(String id) {
    final var roomBooking = roomBookingDAO.selectRoomBookingById(id);
    roomBooking.ifPresentOrElse(
        room -> {
          final var result = roomBookingDAO.deleteRoomBooking(id);
          if (result != 1) {
            throw new IllegalStateException("Could not delete room booking");
          }
        },
        () -> {
          throw new EntityNotFoundException(String.format("Room booking with id %s not found", id));
        });
  }
}
