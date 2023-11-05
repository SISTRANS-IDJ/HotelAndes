package edu.uniandes.hotelandes.user;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDataAccessJDBC implements UserDAO {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public UserDataAccessJDBC(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertUser(User user) {
    final var sql =
        "INSERT INTO hotelandes_user(name, email, id_type, id_number, password, role_id) VALUES(?,"
            + " ?, ?, ?, ?, ?)";
    return jdbcTemplate.update(
        sql,
        user.name(),
        user.email(),
        user.id_type(),
        user.id_number(),
        user.password(),
        user.role_id());
  }

  @Override
  public Optional<User> selectUserById(short id) {
    final var sql =
        "SELECT id, name, email, id_type, id_number, password, role_id FROM hotelandes_user WHERE"
            + " id = ?";
    final var user = jdbcTemplate.query(sql, new UserRowMapper(), id);
    return user.stream().findFirst();
  }

  @Override
  public List<User> selectUsers() {
    final var sql =
        "SELECT id, name, email, id_type, id_number, password, role_id FROM hotelandes_user";
    return jdbcTemplate.query(sql, new UserRowMapper());
  }

  @Override
  public int updateUser(Short id, User user) {
    final var sql =
        "UPDATE user SET name = ?, email = ?, id_type = ?, id_number = ?, password = ?, role_id = ?"
            + " WHERE id = ?";
    return jdbcTemplate.update(
        sql,
        user.name(),
        user.email(),
        user.id_type(),
        user.id_number(),
        user.password(),
        user.role_id(),
        id);
  }

  @Override
  public int deleteUser(int id) {
    final var sql = "DELETE FROM user WHERE CASE id = ?";
    return jdbcTemplate.update(sql, id);
  }
}
