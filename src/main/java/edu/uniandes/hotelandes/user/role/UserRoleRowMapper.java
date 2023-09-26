package edu.uniandes.hotelandes.user.role;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRoleRowMapper implements RowMapper<Role> {
  @Override
  public Role mapRow(ResultSet rs, int i) throws SQLException {
    return new Role(rs.getByte("id"), rs.getString("role"), rs.getString("description"));
  }
}
