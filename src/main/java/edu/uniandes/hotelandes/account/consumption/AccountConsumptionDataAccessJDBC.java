package edu.uniandes.hotelandes.account.consumption;

import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountConsumptionDataAccessJDBC implements AccountConsumptionDAO {
  private final JdbcTemplate jdbcTemplate;

  public AccountConsumptionDataAccessJDBC(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertAccountConsumption(AccountConsumption accountConsumption) {
    final var sql =
        "INSERT INTO hotelandes_account_consumption(account_id, service_id, consumption_date,"
            + " description, cost) VALUES(?, ?, ?, ?, ?)";
    return jdbcTemplate.update(
        sql,
        accountConsumption.accountId(),
        accountConsumption.serviceId(),
        accountConsumption.consumptionDate(),
        accountConsumption.description(),
        accountConsumption.cost());
  }

  @Override
  public Optional<AccountConsumption> selectAccountConsumptionById(long id) {
    final var sql =
        "SELECT id, account_id, service_id, consumption_date, description, cost FROM"
            + " hotelandes_account_consumption WHERE id = ?";
    final var roles = jdbcTemplate.query(sql, new AccountConsumptionRowMapper(), id);
    return roles.stream().findFirst();
  }

  @Override
  public List<AccountConsumption> selectAccountConsumptions() {
    final var sql =
        "SELECT id, account_id, service_id, consumption_date, description, cost FROM"
            + " hotelandes_account_consumption";
    return jdbcTemplate.query(sql, new AccountConsumptionRowMapper());
  }

  @Override
  public int updateAccountConsumption(long id, AccountConsumption accountConsumption) {
    final var sql =
        "UPDATE hotelandes_account_consumption SET account_id = ?, service_id = ?, consumption_date"
            + " = ?, description = ?, cost = ? WHERE id = ?";
    return jdbcTemplate.update(
        sql,
        accountConsumption.accountId(),
        accountConsumption.serviceId(),
        accountConsumption.consumptionDate(),
        accountConsumption.description(),
        accountConsumption.cost(),
        id);
  }

  @Override
  public int deleteAccountConsumption(long id) {
    final var sql = "DELETE FROM hotelandes_account_consumption WHERE id = ?";
    return jdbcTemplate.update(sql, id);
  }
}
