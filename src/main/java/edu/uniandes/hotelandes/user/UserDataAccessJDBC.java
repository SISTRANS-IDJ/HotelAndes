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
  public int insertUser(User user, boolean insertClient) {
    final var sql =
        "INSERT INTO hotelandes_user(name, email, id_type, id_number, password, role_id)"
            + " VALUES(?,?, ?, ?, ?, ?)";

    String type =
        jdbcTemplate.queryForObject(
            "select role from hotelandes_user_role where id = ?", String.class, user.role_id());

    int result =
        jdbcTemplate.update(
            sql,
            user.name(),
            user.email(),
            user.id_type(),
            user.id_number(),
            user.password(),
            user.role_id());

    if (insertClient) {
      Integer thisid =
          jdbcTemplate.queryForObject(
              "select id from hotelandes_user where hotelandes_user.email like ?",
              Integer.class,
              user.email());

      if (type.equals("CLIENT")) {
        this.insertClient(thisid);
      }
    }
    return result;
  }

  public int insertClient(Integer id) {
    final var sql = "INSERT INTO hotelandes_client(id) VALUES(?)";
    return jdbcTemplate.update(sql, id);
  }

  @Override
  public Optional<User> selectUserById(Integer id) {
    final var sql =
        "SELECT id, name, email, id_type, id_number, password, role_id FROM hotelandes_user WHERE"
            + " id = ?";
    final var user = jdbcTemplate.query(sql, new UserRowMapper(), id);
    return user.stream().findFirst();
  }

  @Override
  public Optional<User> selectUserByEmail(String email) {
    final var sql =
        "SELECT id, name, email, id_type, id_number, password, role_id FROM hotelandes_user WHERE"
            + " email = ?";
    final var user = jdbcTemplate.query(sql, new UserRowMapper(), email);
    return user.stream().findFirst();
  }

  @Override
  public List<User> selectUsers() {
    final var sql =
        "SELECT id, name, email, id_type, id_number, password, role_id FROM hotelandes_user";
    return jdbcTemplate.query(sql, new UserRowMapper());
  }

  @Override
  public int updateUser(Integer id, User user) {
<<<<<<< HEAD
    final var sql =
        "UPDATE user SET name = ?, email = ?, id_type = ?, id_number = ?, password = ?, role_id = ?"
            + " WHERE id = ?";
=======
    final var sql = "UPDATE hotelandes_user SET name = ?, email = ?, id_type = ?, id_number = ?, password = ?, role_id = ?"
        + " WHERE id = ?";
>>>>>>> feature-data-generation
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
  public int deleteUser(Integer id) {
    final var sql = "DELETE FROM hotelandes_user WHERE CASE id = ?";
    return jdbcTemplate.update(sql, id);
  }
}
