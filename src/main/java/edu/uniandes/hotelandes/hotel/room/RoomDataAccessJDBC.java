package edu.uniandes.hotelandes.hotel.room;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDataAccessJDBC implements RoomDAO {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public RoomDataAccessJDBC(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertRoom(Room room) {
    final var sql = "INSERT INTO hotel_room(name, room_type_id) VALUES(?, ?)";
    return jdbcTemplate.update(sql, room.name(), room.roomTypeId());
  }

  @Override
  public Optional<Room> selectRoomById(int id) {
    final var sql = "SELECT id, name, room_type_id FROM hotel_room WHERE id = ?";
    final var rooms = jdbcTemplate.query(sql, new RoomRowMapper(), id);
    return rooms.stream().findFirst();
  }

  @Override
  public List<Room> selectRooms() {
    final var sql = "SELECT id, name, room_type_id FROM hotel_room";
    return jdbcTemplate.query(sql, new RoomRowMapper());
  }

  @Override
  public int updateRoom(int id, Room room) {
    final var sql = "UPDATE hotel_room SET name = ?,room_type_id = ? WHERE id = ?";
    return jdbcTemplate.update(sql, room.name(), room.roomTypeId(), id);
  }

  @Override
  public int deleteRoom(int id) {
    final var sql = "DELETE FROM hotel_room WHERE id = ?";
    return jdbcTemplate.update(sql, id);
  }
}
