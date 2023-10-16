package edu.uniandes.hotelandes.user;

import edu.uniandes.hotelandes.exception.NotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserDAO userDAO;

  @Autowired
  public UserService(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public void createUser(User user) {
    final var users = userDAO.insertUser(user);
    if (users != 1) {
      throw new IllegalStateException("User creation went wrong");
    }
  }

  public User getUser(Short id) {
    return userDAO
        .selectUserById(id)
        .orElseThrow(() -> new NotFoundException(String.format("User with id %s not found", id)));
  }

  public List<User> getUsers() {
    return userDAO.selectUsers();
  }

  public User updateUser(Short id, User user) {
    final var users = userDAO.selectUserById(user.id());
    if (users.isPresent()) {
      final var u = userDAO.updateUser(id, user);
      if (u != 1) {
        throw new IllegalStateException("User update went wrong");
      }
      return user;
    } else {
      throw new IllegalStateException("User doesn't exists");
    }
  }

  public void deleteUser(Short id) {
    final var users = userDAO.selectUserById(id);
    users.ifPresent(
        user -> {
          final var result = userDAO.deleteUser(id);
          if (result != 1) {
            throw new IllegalStateException("Could not delete user");
          }
        });
  }
}
