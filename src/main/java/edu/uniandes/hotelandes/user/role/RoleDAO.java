package edu.uniandes.hotelandes.user.role;

import java.util.List;
import java.util.Optional;

public interface RoleDAO {
  int insertRole(Role role);

  Optional<Role> selectRoleById(short id);

  List<Role> selectRoles();

  int updateRole(short id, Role role);

  int deleteRole(int id);
}
