package edu.uniandes.hotelandes.user.role;

import edu.uniandes.hotelandes.exception.EntityAlreadyExists;
import edu.uniandes.hotelandes.exception.EntityDoesNotExists;
import edu.uniandes.hotelandes.exception.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
  private final RoleDataAcessJDBC roleDAO;

  @Autowired
  public UserRoleService(RoleDAO roleDAO) {
    this.roleDAO = (RoleDataAcessJDBC)roleDAO;
  }

  public void createUserRole(Role role) {
    // if (roleDAO.selectRoleById(role.id()).isPresent()) {
    //   throw new EntityAlreadyExists(String.format("User role with id %d already exists", role.id()));
    // }

    roleDAO.insertRole(role);
  }

  public Role getRole(Byte id) {
    return roleDAO
        .selectRoleById(id)
        .orElseThrow(
            () -> new EntityNotFoundException(String.format("Role with id %d not found", id)));
  }

  public List<Role> getRoles() {
    return roleDAO.selectRoles();
  }

  public Role updateRole(Byte id, Role role) {
    if (roleDAO.selectRoleById(role.id()).isEmpty()) {
      throw new EntityDoesNotExists("User role doesn't exists");
    }

    roleDAO.updateRole(id, role);

    return role;
  }

  public void deleteRole(Byte id) {
    if (roleDAO.selectRoleById(id).isEmpty()) {
      throw new EntityDoesNotExists("User role doesn't exists");
    }

    roleDAO.deleteRole(id);
  }
}
