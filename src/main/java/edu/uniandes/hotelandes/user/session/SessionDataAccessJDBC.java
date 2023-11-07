package edu.uniandes.hotelandes.user.session;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SessionDataAccessJDBC implements SessionDAO {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public SessionDataAccessJDBC(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertSession(Session session) {
    final var sql =
        """
                INSERT INTO hotelandes_user_session(userId) VALUES(?)
                """;

    return jdbcTemplate.update(sql, session.userId());
  }

  @Override
  public Optional<Session> selectSessionByUserId(Integer id) {
    final var sql =
        """
                SELECT id, user_id FROM hotelandes_user_session WHERE id = ?
                """;

    final var sessions = jdbcTemplate.query(sql, new SessionRowMapper(), id);
    return sessions.stream().findFirst();
  }

  @Override
  public List<Session> selectSessions() {
    final var sql =
        """
                SELECT id, user_id FROM hotelandes_user_session
                """;
    return jdbcTemplate.query(sql, new SessionRowMapper());
  }

  @Override
  public int deleteSession(Long id) {
    final var sql =
        """
                DELETE FROM
                hotelandes_user_session
                WHERE id = ?
                """;

    return jdbcTemplate.update(sql, id);
  }

  @Override
  public int deleteSessionByUserId(Integer id) {
    final var sql =
        """
                    DELETE FROM
                    hotelandes_user_session
                    WHERE user_id = ?
                """;

    return jdbcTemplate.update(sql, id);
  }
}
