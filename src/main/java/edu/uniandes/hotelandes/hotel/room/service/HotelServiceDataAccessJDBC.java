package edu.uniandes.hotelandes.hotel.room.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HotelServiceDataAccessJDBC implements HotelServiceDAO {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public HotelServiceDataAccessJDBC(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertService(HotelService service) {
    final var sql =
        "INSERT INTO hotelandes_service(name, description, opening_time, closing_time)"
            + " VALUES(?, ?, ?, ?)";
    return jdbcTemplate.update(
        sql,
        service.name(),
        service.description(),
        service.openingTime(),
        service.closingTime()
    );
  }

  @Override
  public Optional<HotelService> selectServiceById(int id) {
    final var sql =
        "SELECT id, name, description, opening_time, closing_time FROM hotelandes_service"
            + " WHERE id = ?";
    final var service = jdbcTemplate.query(sql, new HotelServiceRowMapper(), id);
    return service.stream().findFirst();
  }

  @Override
  public List<HotelService> selectServices() {
    final var sql =
        "SELECT id, name, description, opening_time, closing_time FROM hotelandes_service";
    return jdbcTemplate.query(sql, new HotelServiceRowMapper());
  }

  @Override
  public int updateService(int id, HotelService service) {
    final var sql =
        "UPDATE hotelandes_service SET name = ?, description = ?, opening_time = ?, closing_time = ?,"
            + " WHERE id = ?";
    return jdbcTemplate.update(
        sql,
        service.name(),
        service.description(),
        service.openingTime(),
        service.closingTime(),
        id);
  }

  @Override
  public int deleteService(int id) {
    final var sql = "DELETE FROM hotelandes_service WHERE CASE id = ?";
    return jdbcTemplate.update(sql, id);
  }
}
