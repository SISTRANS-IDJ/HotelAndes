package edu.uniandes.hotelandes.user.role;

import java.util.List;
import java.util.Optional;

public interface RoleDAO {
  int insertRole(Role role);

  Optional<Role> selectRoleById(byte id);

  List<Role> selectRoles();

  int updateRole(byte id, Role role);

  int deleteRole(byte id);
}
