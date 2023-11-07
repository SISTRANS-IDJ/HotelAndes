package edu.uniandes.hotelandes.hotel.room;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RoomRowMapper implements RowMapper<Room> {
  @Override
  public Room mapRow(ResultSet rs, int i) throws SQLException {
    return new Room(rs.getInt("id"), rs.getString("name"), rs.getInt("room_type_id"));
  }
}
