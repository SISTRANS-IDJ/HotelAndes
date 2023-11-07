package edu.uniandes.hotelandes.user.session;

import java.util.List;
import java.util.Optional;

public interface SessionDAO {
  int insertSession(Session session);

  Optional<Session> selectSessionByUserId(Integer id);

  List<Session> selectSessions();

  int deleteSession(Long id);

  int deleteSessionByUserId(Integer id);
}
