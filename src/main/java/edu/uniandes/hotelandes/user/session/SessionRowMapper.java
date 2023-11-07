package edu.uniandes.hotelandes.user.session;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SessionRowMapper implements RowMapper<Session> {
  @Override
  public Session mapRow(ResultSet rs, int i) throws SQLException {
    return new Session(rs.getLong("id"), rs.getInt("user_id"));
  }
}
