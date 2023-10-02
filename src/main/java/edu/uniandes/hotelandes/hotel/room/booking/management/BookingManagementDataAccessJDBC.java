package edu.uniandes.hotelandes.hotel.room.booking.management;

import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingManagementDataAccessJDBC implements BookingManagementDAO {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public BookingManagementDataAccessJDBC(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Optional<Date> selectCheckIn(String roomBookingId) {
    final var sql = "SELECT check_in FROM room_booking WHERE id = ?";
    final var checkIn = jdbcTemplate.queryForObject(sql, Date.class, roomBookingId);
    return Optional.of(checkIn);
  }

  @Override
  public int updateCheckIn(String roomBookingId, Date checkIn) {
    final var sql = "UPDATE room_booking SET check_in = ? WHERE id = ?";
    return jdbcTemplate.update(sql, checkIn, roomBookingId);
  }

  @Override
  public Optional<Date> selectCheckOut(String roomBookingId) {
    final var sql = "SELECT check_out FROM room_booking WHERE id = ?";
    final var checkOut = jdbcTemplate.queryForObject(sql, Date.class, roomBookingId);
    return Optional.of(checkOut);
  }

  @Override
  public int updateCheckOut(String roomBookingId, Date checkOut) {
    final var sql = "UPDATE room_booking SET check_out = ? WHERE id = ?";
    return jdbcTemplate.update(sql, checkOut, roomBookingId);
  }
}
