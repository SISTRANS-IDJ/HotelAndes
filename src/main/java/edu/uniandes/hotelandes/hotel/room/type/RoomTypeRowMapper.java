package edu.uniandes.hotelandes.hotel.room.type;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RoomTypeRowMapper implements RowMapper<RoomType> {
  @Override
  public RoomType mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new RoomType(
        rs.getInt("id"),
        rs.getString("name"),
        rs.getString("description"),
        rs.getDouble("price_per_night"),
        rs.getShort("capacity"));
  }
}
