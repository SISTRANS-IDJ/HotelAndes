package edu.uniandes.hotelandes.user.role;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user/role")
public class UserRoleController {
  private final UserRoleService userRoleService;

  @Autowired
  public UserRoleController(UserRoleService userRoleService) {
    this.userRoleService = userRoleService;
  }

  @PostMapping
  public void createUserRole(@RequestBody Role role) {
    userRoleService.createUserRole(role);
  }

  @GetMapping("{id}")
  public Role getRoleId(@PathVariable("id") Short id) {
    return userRoleService.getRole(id);
  }

  @GetMapping
  public List<Role> listRoles() {
    return userRoleService.getRoles();
  }

  @PutMapping("{id}")
  public Role updateRole(@PathVariable Short id, @RequestBody Role role) {
    return userRoleService.updateRole(id, role);
  }

  @DeleteMapping("{id}")
  public void deleteRole(@PathVariable("id") Short id) {
    userRoleService.deleteRole(id);
  }
}
