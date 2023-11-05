import edu.uniandes.hotelandes.user.role.RoleDAO;
import edu.uniandes.hotelandes.user.role.RoleGenerator;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;

class DataGeneratorService{

    @Autowired
    public DataGeneratorService(RoleDAO roleDAO){
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
}