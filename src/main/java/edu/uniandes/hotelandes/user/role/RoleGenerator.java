import net.datafaker.Faker;
import Role;

public class RoleGenerator{

    static public generateRole(Faker faker){
        String roleName = faker.name().firstName();
        String roleDesc = faker.Lorem();
        Role role = Role(1, roleName, roleDesc);
    }
}