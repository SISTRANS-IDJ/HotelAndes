package edu.uniandes.hotelandes.user.client.account;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class AccountRowMapper implements RowMapper<Account> {

  @Override
  @Nullable public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Account(
        rs.getInt("id"),
        rs.getInt("room_booking_id"),
        rs.getDouble("total"),
        rs.getDouble("balance"),
        rs.getString("state"));
  }
}
