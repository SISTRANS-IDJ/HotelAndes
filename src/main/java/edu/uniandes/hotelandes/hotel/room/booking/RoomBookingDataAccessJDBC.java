package edu.uniandes.hotelandes.hotel.room.booking;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomBookingDataAccessJDBC implements RoomBookingDAO {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public RoomBookingDataAccessJDBC(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
  
  public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
    return java.sql.Date.valueOf(dateToConvert);
}

  @Override
  public int insertRoomBooking(RoomBooking roomBooking) {
    final var sql =
        """
            INSERT INTO
            hotel_room_booking( client_id, hotel_room_id,check_in, check_out, consumption_plan_id)
            VALUES( ?, ?, ?, ?, ?)
            """;
    return jdbcTemplate.update(
        sql,
        roomBooking.clientId(),
        roomBooking.hotelRoomId(),
        roomBooking.checkIn(),
        roomBooking.checkOut(),
        roomBooking.consumptionPlanId());
  }

  @Override
  public Optional<RoomBooking> selectRoomBookingById(Integer id) {
    final var sql =
        """
            SELECT
            id, client_id, hotel_room_id,check_in, check_out, consumption_plan_id
            FROM hotel_room_booking WHERE id = ?
            """;
    final var roomBookings = jdbcTemplate.query(sql, new RoomBookingRowMapper(), id);
    return roomBookings.stream().findFirst();
  }

  @Override
  public List<RoomBooking> selectRoomBookings() {
    final var sql =
        """
            SELECT
            id, client_id, hotel_room_id, check_in, check_out, consumption_plan_id
            FROM hotel_room_booking
            """;
    return jdbcTemplate.query(sql, new RoomBookingRowMapper());
  }

  @Override
  public int updateRoomBooking(Integer id, RoomBooking roomBooking) {
    final var sql =
        """
            UPDATE
            hotel_room_booking
            SET
            client_id = ?, hotel_room_id = ?,check_in = ?, check_out = ?, consumption_plan_id = ?
            WHERE id = ?
            """;
    return jdbcTemplate.update(
        sql,
        roomBooking.clientId(),
        roomBooking.checkIn(),
        roomBooking.checkOut(),
        roomBooking.consumptionPlanId(),
        id);
  }

  @Override
  public int deleteRoomBooking(Integer id) {
    final var sql = "DELETE FROM hotel_room_booking WHERE id = ?";
    return jdbcTemplate.update(sql, id);
  }
}
