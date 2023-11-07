package edu.uniandes.hotelandes.hotel.room.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class HotelServiceRowMapper implements RowMapper<HotelService> {
  @Override
  public HotelService mapRow(ResultSet rs, int i) throws SQLException {
    return new HotelService(
        rs.getInt("id"),
        rs.getString("name"),
        rs.getString("description"),
        rs.getString("opening_time"),
        rs.getString("closing_time"));
  }
}
