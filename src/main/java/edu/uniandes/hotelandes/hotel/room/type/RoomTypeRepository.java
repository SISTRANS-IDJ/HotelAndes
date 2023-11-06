package edu.uniandes.hotelandes.hotel.room.type;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomTypeRepository implements RoomTypeDao {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public RoomTypeRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertRoomType(RoomType roomType) {
    final var sql =
        "INSERT INTO hotel_room_type(name, description, capacity, price_per_night) VALUES( ?, ?, ?,?)";
    return jdbcTemplate.update(
        sql,
        roomType.name(),
        roomType.description(),
        roomType.capacity(),
        roomType.price_per_night());
  }

  @Override
  public Optional<RoomType> selectRoomTypeById(int id) {
    final var sql =
        "SELECT id, name, description, capacity, price FROM hotel_room_type WHERE id = ?";
    final var roomTypes = jdbcTemplate.query(sql, new RoomTypeRowMapper(), id);
    return roomTypes.stream().findFirst();
  }

  @Override
  public List<RoomType> selectRoomTypes() {
    final var sql = "SELECT id, name, description, capacity, price_per_night FROM hotel_room_type";
    return jdbcTemplate.query(sql, new RoomTypeRowMapper());
  }

  @Override
  public int updateRoomType(int id, RoomType roomType) {
    final var sql =
        "UPDATE hotel_room_type SET name = ?, description = ?, capacity = ?, pricePerNight = ?"
            + " WHERE id = ?";
    return jdbcTemplate.update(
        sql,
        roomType.name(),
        roomType.description(),
        roomType.capacity(),
        roomType.price_per_night(),
        id);
  }

  @Override
  public int deleteRoomType(int id) {
    final var sql = "DELETE FROM hotel_room_type WHERE id = ?";
    return jdbcTemplate.update(sql, id);
  }
}
