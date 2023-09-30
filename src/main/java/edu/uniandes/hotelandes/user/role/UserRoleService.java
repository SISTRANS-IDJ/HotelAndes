package edu.uniandes.hotelandes.user.role;

import edu.uniandes.hotelandes.exception.NotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
  private final RoleDAO roleDAO;

  @Autowired
  public UserRoleService(RoleDAO roleDAO) {
    this.roleDAO = roleDAO;
  }

  public void createUserRole(Role role) {
    final var roles = roleDAO.selectRoleById(role.id());
    if (roles.isEmpty()) {
      final var r = roleDAO.insertRole(role);
      if (r != 1) {
        throw new IllegalStateException("User role creation went wrong");
      }
    } else {
      throw new IllegalStateException("User role already exists");
    }
  }

  public Role getRole(Short id) {
    return roleDAO
        .selectRoleById(id)
        .orElseThrow(() -> new NotFoundException(String.format("Role with id %s not found", id)));
  }

  public List<Role> getRoles() {
    return roleDAO.selectRoles();
  }

  public Role updateRole(Short id, Role role) {
    final var roles = roleDAO.selectRoleById(role.id());
    if (roles.isPresent()) {
      final var r = roleDAO.updateRole(id, role);
      if (r != 1) {
        throw new IllegalStateException("User role update went wrong");
      }
      return role;
    } else {
      throw new IllegalStateException("User role doesn't exists");
    }
  }

  public void deleteRole(Short id) {
    final var roles = roleDAO.selectRoleById(id);
    roles.ifPresentOrElse(
        role -> {
          final var result = roleDAO.deleteRole(id);
          if (result != 1) {
            throw new IllegalStateException("Could not delete role");
          }
        },
        () -> {
          throw new NotFoundException(String.format("Role with id %s not found", id));
        });
  }
}
