package edu.uniandes.hotelandes.user;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
  int insertUser(User user, boolean insertClient);

  Optional<User> selectUserById(Integer id);

  Optional<User> selectUserByEmail(String name);

  List<User> selectUsers();

  int updateUser(Integer id, User role);

  int deleteUser(Integer id);
}
