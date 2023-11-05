package edu.uniandes.hotelandes.hotel.consumptionPlan;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ConsumptionPlanRowMapper implements RowMapper<ConsumptionPlan> {
  @Override
  public ConsumptionPlan mapRow(ResultSet rs, int i) throws SQLException {
    return new ConsumptionPlan(
        rs.getInt("id"),
        rs.getString("plan_name"),
        rs.getString("plan_description"),
        rs.getFloat("stay_discount"),
        rs.getFloat("fixed_cost"));
  }
}
