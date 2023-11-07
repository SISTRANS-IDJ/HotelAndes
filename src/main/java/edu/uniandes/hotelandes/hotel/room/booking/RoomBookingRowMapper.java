package edu.uniandes.hotelandes.hotel.room.booking;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RoomBookingRowMapper implements RowMapper<RoomBooking> {
  @Override
  public RoomBooking mapRow(ResultSet rs, int i) throws SQLException {
    return new RoomBooking(
        rs.getString("id"),
        rs.getInt("clientId"),
        rs.getInt("hotel_room_id"),
        rs.getDate("check_in"),
        rs.getDate("check_out"),
        rs.getByte("consumption_plan_id"));
  }
}
