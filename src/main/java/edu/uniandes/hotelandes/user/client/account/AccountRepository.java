package edu.uniandes.hotelandes.user.client.account;

import edu.uniandes.hotelandes.exception.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======
import edu.uniandes.hotelandes.exception.EntityNotFoundException;

@Repository
>>>>>>> feature-data-generation
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

<<<<<<< HEAD
  @Override
  public Optional<Account> selectAccountById(Integer id) {
    final var sql =
        """
                SELECT *
=======
    @Override
    public Optional<Account> selectAccountById(Integer id) {
        final var sql = """
                SELECT id, room_booking_id, total, balance, state
>>>>>>> feature-data-generation
                FROM hotelandes_client_account
                WHERE id = ?
                """;
    final var accounts = jdbcTemplate.query(sql, new AccountRowMapper(), id);
    return accounts.stream().findFirst();
  }

<<<<<<< HEAD
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
=======
    @Override
    public List<Account> selectAccounts() {
        final var sql = """
                SELECT id, room_booking_id, total, balance, state
                FROM hotelandes_client_account
                """;
        return jdbcTemplate.query(sql, new AccountRowMapper());
>>>>>>> feature-data-generation
    }
  }

<<<<<<< HEAD
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
=======
    @Override
    public int updateAccount(Integer id, Account newAccount) {
        final var sql = """
                UPDATE hotelandes_client_account
                SET  room_booking_id = ?, total = ?, balance = ?, state = ?
                """;
        return jdbcTemplate.update(
                sql,
                newAccount.room_booking_id(),
                newAccount.total(),
                newAccount.balance(),
                newAccount.state());
>>>>>>> feature-data-generation
    }
  }
}
