package edu.uniandes.hotelandes.account.consumption;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AccountConsumptionRowMapper implements RowMapper<AccountConsumption> {
  @Override
  public AccountConsumption mapRow(ResultSet rs, int i) throws SQLException {
    return new AccountConsumption(
        rs.getLong("id"),
        rs.getLong("account_id"),
        rs.getLong("service_id"),
        rs.getDate("consumption_date"),
        rs.getString("description"),
        rs.getDouble("cost"));
  }
}
