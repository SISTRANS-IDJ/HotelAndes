package edu.uniandes.hotelandes.hotel.room.hotelService.serviceBooking;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceBookingDataAccessJDBC implements ServiceBookingDAO {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ServiceBookingDataAccessJDBC(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertServiceBooking(ServiceBooking serviceBooking) {
    final var sql =
        "INSERT INTO service_booking(booking_start, booking_end, service_id, client_id)"
            + " VALUES(?, ?, ?, ?)";
    return jdbcTemplate.update(
        sql,
        serviceBooking.bookingStart(),
        serviceBooking.bookingEnd(),
        serviceBooking.serviceId(),
        serviceBooking.userId());
  }

  @Override
  public Optional<ServiceBooking> selectServiceBookingById(int id) {
    final var sql =
        "SELECT id, booking_start, booking_end, service_id, user_id FROM service_booking"
            + " WHERE id = ?";
    final var serviceBooking = jdbcTemplate.query(sql, new ServiceBookingRowMapper(), id);
    return serviceBooking.stream().findFirst();
  }

  @Override
  public List<ServiceBooking> selectServiceBookings() {
    final var sql =
        "SELECT id, booking_start, booking_end, service_id, user_id FROM service_booking";
    return jdbcTemplate.query(sql, new ServiceBookingRowMapper());
  }

  @Override
  public int updateServiceBooking(int id, ServiceBooking serviceBooking) {
    final var sql =
        "UPDATE service_booking SET booking_start = ?, booking_end = ?, service_id = ?,"
            + " user_id = ? WHERE id = ?";
    return jdbcTemplate.update(
        sql,
        serviceBooking.bookingStart(),
        serviceBooking.bookingEnd(),
        serviceBooking.serviceId(),
        serviceBooking.userId(),
        id);
  }

  @Override
  public int deleteServiceBooking(int id) {
    final var sql = "DELETE FROM service_booking WHERE id = ?";
    return jdbcTemplate.update(sql, id);
  }
}
