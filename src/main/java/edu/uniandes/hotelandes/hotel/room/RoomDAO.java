package edu.uniandes.hotelandes.hotel.room;

import java.util.List;
import java.util.Optional;

public interface RoomDAO {
  int insertRoom(Room room);

  Optional<Room> selectRoomById(int id);

  List<Room> selectRooms();

  int updateRoom(int id, Room room);

  int deleteRoom(int id);
}
