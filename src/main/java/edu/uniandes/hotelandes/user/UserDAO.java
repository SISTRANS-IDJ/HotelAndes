package edu.uniandes.hotelandes.user;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
  int insertUser(User user);

  Optional<User> selectUserById(short id);

  List<User> selectUsers();

  int updateUser(Short id, User role);

  int deleteUser(int id);
}
