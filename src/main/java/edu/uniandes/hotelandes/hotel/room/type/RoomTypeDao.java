package edu.uniandes.hotelandes.hotel.room.type;

import java.util.List;
import java.util.Optional;

public interface RoomTypeDao {
  int insertRoomType(RoomType roomType);

  Optional<RoomType> selectRoomTypeById(int id);

  List<RoomType> selectRoomTypes();

  int updateRoomType(int id, RoomType roomType);

  int deleteRoomType(int id);
}
