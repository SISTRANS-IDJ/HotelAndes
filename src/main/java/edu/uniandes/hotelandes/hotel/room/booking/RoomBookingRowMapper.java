package edu.uniandes.hotelandes.hotel.room.booking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class RoomBookingRowMapper implements RowMapper<RoomBooking> {

  public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
}
  @Override
  public RoomBooking mapRow(ResultSet rs, int i) throws SQLException {
    return new RoomBooking(
        rs.getInt("id"),
        rs.getInt("clientId"),
        rs.getInt("hotel_room_id"),
        convertToLocalDateViaInstant(rs.getDate("check_in")),
        convertToLocalDateViaInstant(rs.getDate("check_out")),
        rs.getInt("consumption_plan_id"));
  }
}
