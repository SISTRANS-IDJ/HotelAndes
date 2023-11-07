package edu.uniandes.hotelandes.user.client.account;

import edu.uniandes.hotelandes.exception.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountRepository implements AccountDAO {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public AccountRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertAccount(Account account) {
    final var sql =
        """
                INSERT INTO hotelandes_client_account ( room_booking_id, total, balance, state)
                VALUES (?,0,0,'OPEN')
                    """;
    return jdbcTemplate.update(sql, account.room_booking_id());
  }

  @Override
  public Optional<Account> selectAccountById(Integer id) {
    final var sql =
        """
                SELECT *
                FROM hotelandes_client_account
                WHERE id = ?
                """;
    final var accounts = jdbcTemplate.query(sql, new AccountRowMapper(), id);
    return accounts.stream().findFirst();
  }

  @Override
  public List<Account> selectAccounts() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'selectAccounts'");
  }

  @Override
  public int increaseTotal(Integer id, Float cost) {
    Optional<Account> acc = this.selectAccountById(id);
    if (acc.isPresent()) {
      Account account = acc.get();
      Account newAccount =
          new Account(
              account.id(),
              account.room_booking_id(),
              account.total() + cost,
              account.balance(),
              account.state());
      return this.insertAccount(newAccount);
    } else {
      throw new EntityNotFoundException("No se encontro la cuenta");
    }
  }

  @Override
  public int decreaseBalance(Integer id, Float cost) {
    Optional<Account> acc = this.selectAccountById(id);
    if (acc.isPresent()) {
      Account account = acc.get();
      Account newAccount =
          new Account(
              account.id(),
              account.room_booking_id(),
              account.total(),
              account.balance() - cost,
              account.state());
      return this.insertAccount(newAccount);
    } else {
      throw new EntityNotFoundException("No se encontro la cuenta");
    }
  }
}
