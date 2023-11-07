package edu.uniandes.hotelandes.user;

import edu.uniandes.hotelandes.user.role.Role;
import edu.uniandes.hotelandes.user.role.UserRoleService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGenerator {

  private UserRoleService userRoleService;

  private Integer newid = 1;
  private List<Byte> nRoles = new ArrayList<Byte>();
  private Random rand = new Random();

  @Autowired
  public UserGenerator(UserRoleService userRoleService) {
    this.userRoleService = userRoleService;
  }

  private Byte getValidUserRoleID() {
    // List<Role> roles = userRoleService.getRoles();
    Byte id = nRoles.get(this.rand.nextInt(nRoles.size()));
    return id;
  }

  public User generateUser(Faker faker) {
    if (this.nRoles.size() == 0) {
      List<Role> roles = userRoleService.getRoles();
      for (Role r : roles) {
        nRoles.add(r.id());
      }
    }
    String id_type = "CC";
    String id_number = faker.number().digits(10);
    String password = faker.number().digits(20);
    String name = faker.name().firstName();
    String lastName = faker.name().lastName();
    String companyName = faker.company().name().toLowerCase().replaceAll("[^a-z]", "");
    String email =
        name.toLowerCase()
            + "."
            + lastName.toLowerCase()
            + newid.toString()
            + "@"
            + faker.domain().firstLevelDomain(companyName);
    Byte role_id = getValidUserRoleID();
    User user = new User(null, name + " " + lastName, email, id_type, id_number, password, role_id);
    newid++;
    return user;
  }
}
