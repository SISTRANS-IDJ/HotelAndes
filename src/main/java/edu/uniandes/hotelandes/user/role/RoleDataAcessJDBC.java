package edu.uniandes.hotelandes.user.role;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDataAcessJDBC implements RoleDAO {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public RoleDataAcessJDBC(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertRole(Role role) {
    final var sql = "INSERT INTO user_role(role, description) VALUES(?, ?)";
    return jdbcTemplate.update(sql, role.role(), role.description());
  }

  @Override
  public Optional<Role> selectRoleById(short id) {
    final var sql = "SELECT id, role, description FROM user_role WHERE id = ?";
    final var roles = jdbcTemplate.query(sql, new UserRoleRowMapper(), id);
    return roles.stream().findFirst();
  }

  @Override
  public List<Role> selectRoles() {
    final var sql = "SELECT id, role, description FROM user_role";
    return jdbcTemplate.query(sql, new UserRoleRowMapper());
  }

  @Override
  public int updateRole(short id, Role role) {
    final var sql = "UPDATE user_role SET role = ?, description = ? WHERE id = ?";
    return jdbcTemplate.update(sql, role.role(), role.description(), id);
  }

  @Override
  public int deleteRole(int id) {
    final var sql = "DELETE FROM user_role WHERE CASE id = ?";
    return jdbcTemplate.update(sql, id);
  }
}
