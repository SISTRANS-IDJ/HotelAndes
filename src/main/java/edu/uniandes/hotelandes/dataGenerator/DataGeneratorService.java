import edu.uniandes.hotelandes.account.consumption.AccountConsumption;
import edu.uniandes.hotelandes.account.consumption.AccountConsumptionService;
import edu.uniandes.hotelandes.account.consumption.AccountConsumptionGenerator;
import edu.uniandes.hotelandes.user.role.RoleDAO;
import edu.uniandes.hotelandes.user.role.RoleGenerator;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class DataGeneratorService{

    @Autowired
    public DataGeneratorService(RoleDAO roleDAO){
        this.roleDAO = roleDAO;
    };

    @Autowired
    private AccountConsumptionGenerator accountConsumptionGenerator;

    public void generateDataAccountConsumption(){
        Faker faker = new Faker();
        for(int i = 1; i < 500000; i++){
            AccountConsumption accountConsumption = accountConsumptionGenerator.generateAccountConsumption(faker);
            AccountConsumptionService.createAccountConsumption(accountConsumption);
        }
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

