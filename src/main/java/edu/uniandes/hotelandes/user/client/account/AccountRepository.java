package edu.uniandes.hotelandes.user.client.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.uniandes.hotelandes.exception.EntityNotFoundException;

@Repository
public class AccountRepository implements AccountDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertAccount(Account account) {
        final var sql = """
                INSERT INTO hotelandes_client_account ( room_booking_id, total, balance, state)
                VALUES (?,?,?,?)
                    """;
        return jdbcTemplate.update(
                sql,
                account.room_booking_id(),
                account.total(),
                account.balance(),
                account.state().name()
                );
    }

    @Override
    public Optional<Account> selectAccountById(Integer id) {
        final var sql = """
                SELECT id, room_booking_id, total, balance, state
                FROM hotelandes_client_account
                WHERE id = ?
                """;
        final var accounts = jdbcTemplate.query(sql, new AccountRowMapper(), id);
        return accounts.stream().findFirst();
    }

    @Override
    public List<Account> selectAccounts() {
        final var sql = """
                SELECT id, room_booking_id, total, balance, state
                FROM hotelandes_client_account
                """;
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }

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
    }

}
