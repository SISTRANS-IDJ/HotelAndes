package edu.uniandes.hotelandes.hotel.room;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDataAccessJDBC implements RoomDAO {
  @Override
  public int insertRoom(Room room) {
    return 0;
  }

  @Override
  public Optional<Room> selectRoomById(int id) {
    return Optional.empty();
  }

  @Override
  public List<Room> selectRooms() {
    return null;
  }

  @Override
  public int updateRoom(int id, Room room) {
    return 0;
  }

  @Override
  public int deleteRoom(int id) {
    return 0;
  }
}
