package edu.uniandes.hotelandes.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {
  @Override
  public User mapRow(ResultSet rs, int i) throws SQLException {
    return new User(
        rs.getByte("id"),
        rs.getString("name"),
        rs.getString("email"),
        rs.getString("id_type"),
        rs.getString("id_number"),
        rs.getString("password"),
        rs.getByte("role_id"));
  }
}
