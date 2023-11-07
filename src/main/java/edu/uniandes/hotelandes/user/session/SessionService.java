package edu.uniandes.hotelandes.user.session;

import edu.uniandes.hotelandes.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

  private final SessionDAO sessionDAO;

  private final UserDAO userDAO;

  @Autowired
  public SessionService(SessionDAO sessionDAO, UserDAO userDAO) {
    this.sessionDAO = sessionDAO;
    this.userDAO = userDAO;
  }

  public Session login(String email, String password) {
    final var user = userDAO.selectUserByEmail(email);
    if (user.isPresent() && password.equals(user.get().password())) {
      final var session = new Session(null, user.get().id());
      sessionDAO.insertSession(session);

      final var s = sessionDAO.selectSessionByUserId(user.get().id());
      if (s.isPresent()) {
        return s.get();
      }
    }
    return null;
  }

  public Session getSession(Integer userId) {
    final var s = sessionDAO.selectSessionByUserId(userId);
    return s.orElse(null);
  }

  public void logout(String email) {
    final var user = userDAO.selectUserByEmail(email);
    if (user.isPresent()) {
      final var u = user.get();

      sessionDAO.deleteSessionByUserId(u.id());
    }
  }
}
