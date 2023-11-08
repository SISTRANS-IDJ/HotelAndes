package edu.uniandes.hotelandes.dataGenerator;

import edu.uniandes.hotelandes.account.consumption.AccountConsumption;
import edu.uniandes.hotelandes.account.consumption.AccountConsumptionGenerator;
import edu.uniandes.hotelandes.account.consumption.AccountConsumptionService;
import edu.uniandes.hotelandes.hotel.consumptionPlan.ConsumptionPlanGenerator;
import edu.uniandes.hotelandes.hotel.consumptionPlan.ConsumptionPlanService;
import edu.uniandes.hotelandes.hotel.room.Room;
import edu.uniandes.hotelandes.hotel.room.RoomGenerator;
import edu.uniandes.hotelandes.hotel.room.RoomService;
import edu.uniandes.hotelandes.hotel.room.hotelService.product.Product;
import edu.uniandes.hotelandes.hotel.room.hotelService.product.ProductGenerator;
import edu.uniandes.hotelandes.hotel.room.hotelService.product.ProductService;
import edu.uniandes.hotelandes.hotel.room.hotelService.serviceBooking.ServiceBookingGenerator;
import edu.uniandes.hotelandes.hotel.room.hotelService.serviceBooking.ServiceBookingService;
import edu.uniandes.hotelandes.hotel.room.service.HotelService;
import edu.uniandes.hotelandes.hotel.room.service.HotelServiceGenerator;
import edu.uniandes.hotelandes.hotel.room.service.HotelServiceService;
import edu.uniandes.hotelandes.hotel.room.type.RoomType;
import edu.uniandes.hotelandes.hotel.room.type.RoomTypeGenerator;
import edu.uniandes.hotelandes.hotel.room.type.RoomTypeService;
import edu.uniandes.hotelandes.user.User;
import edu.uniandes.hotelandes.user.UserGenerator;
import edu.uniandes.hotelandes.user.UserService;
import edu.uniandes.hotelandes.user.client.account.AccountGenerator;
import edu.uniandes.hotelandes.user.client.account.AccountService;
import edu.uniandes.hotelandes.user.role.Role;
import edu.uniandes.hotelandes.user.role.RoleGenerator;
import edu.uniandes.hotelandes.user.role.UserRoleService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
class DataGeneratorService {

  private Faker faker = new Faker();

  @Autowired private UserRoleService userRoleService;

  @Autowired private HotelServiceService hotelServiceService;

  @Autowired private RoomTypeService roomTypeService;

  @Autowired private UserService userService;

  @Autowired private UserGenerator userGenerator;

  @Autowired private AccountConsumptionService accountConsumptionService;

  @Autowired private AccountConsumptionGenerator accountConsumptionGenerator;

  @Autowired private RoomGenerator roomGenerator;

  @Autowired private ProductGenerator productGenerator;

  @Autowired private ProductService productService;

  @Autowired private ServiceBookingGenerator serviceBookingGenerator;

  @Autowired private ServiceBookingService serviceBookingService;

	@Autowired
	private AccountGenerator accountGenerator;

	@Autowired
	private AccountService accountService;

    @Autowired
    private ConsumptionPlanService consumptionPlanService;

	@Autowired
	private RoomService roomService;

  @Autowired private JdbcTemplate jdbcTemplate;

  @Autowired private ApplicationContext applicationContext;

  public void insertData() {
    /* 
    * hotelandes_user_role
     * hotelandes_room_type
		 * hotel_room
		 * hotelandes_service
		 * hotelandes_user
		 * hotelandes_client
		 * hotel_room_booking
		 * hotelandes_client_account
		 * hotelandes_account_consumption
		 * consumption_plan
		 * product
		 * service_booking
		 */

    this.insertRoles();
		this.insertRoomTypes();
        this.insertConsumptionPlans();
		this.insertRooms();
		this.insertServices();
		this.insertProducts();
		this.insertUsers();
		this.insertClients();
		this.insertServiceBookings();
    // TODO BOOKING
    //  TODO CLIENT ACCOUNT
    // TODO ACCOUNT CONSUMPTION
    // TODO CONSUMPTION PLAN
		// this.insertAccounts();
		// this.insertAccountConsumptions();
		//this.insertServiceBookings();
	}

  public void createTables() throws SQLException {
    DataSource ds = (DataSource) applicationContext.getBean("dataSource");
    Connection c = ds.getConnection();
    SpringScriptUtil.runScript("sql/schema.sql", c);
  }

  public void dropTables() throws SQLException {
    DataSource ds = (DataSource) applicationContext.getBean("dataSource");
    Connection c = ds.getConnection();
    SpringScriptUtil.runScript("sql/tear_down.sql", c);
  }

  public void insertRoles() {
    ArrayList<Role> roles = RoleGenerator.generateRoles(this.faker);
    for (Role role : roles) {
      userRoleService.createUserRole(role);
    }
  }

  public void insertRoomTypes() {
    ArrayList<RoomType> roomTypes = RoomTypeGenerator.generateBasicRoomTypes(faker);
    for (RoomType roomType : roomTypes) {
      roomTypeService.createRoomType(roomType);
    }
  }

  public void insertRooms() {
    ArrayList<Room> rooms = this.roomGenerator.generateRooms();
    for (Room r : rooms) {
      this.roomService.createRoom(r);
    }
  }

  public void insertUsers() {
    for (int i = 0; i < 10; i++) {

      User user = this.userGenerator.generateUser(faker);
      this.userService.createUser(user, false);
    }
  }

  public void insertClients() {
    final var sql =
        """
				INSERT INTO hotelandes_client (id)
				SELECT b.id
				FROM hotelandes_user_role a join hotelandes_user b on a.id = b.role_id
				where a.role like 'CLIENT'
					""";
    jdbcTemplate.update(sql);
  }

  public void insertServices() {
    ArrayList<HotelService> services = HotelServiceGenerator.generateHotelServices(this.faker);
    for (HotelService service : services) {
      hotelServiceService.createService(service);
    }
  }

  public void insertAccountConsumptions() {
    for (int i = 0; i < 1000; i++) {
      AccountConsumption accountConsumption =
          accountConsumptionGenerator.generateAccountConsumption(faker);
      this.accountConsumptionService.createAccountConsumption(accountConsumption);
    }
  }

  public void insertProducts() {
    for (int i = 0; i < 10; i++) {
      Product product = productGenerator.generateProduct(faker);
      this.productService.createProduct(product);
    }
  }

	public void insertServiceBookings() {
		for (int i = 0; i < 10; i++) {
			var serviceBooking = serviceBookingGenerator.generateServiceBooking(faker);
			this.serviceBookingService.createServiceBooking(serviceBooking);
		}
	}
	public void insertAccounts() {
		for (int i = 0; i < 10; i++) {
			var account = accountGenerator.generateAccount(faker);
			this.accountService.createAccount(account);
		}
	}

    public void insertConsumptionPlans() {
        var consumptionPlans = ConsumptionPlanGenerator.generateConusmptionPlan(faker);
        for (var consumptionPlan : consumptionPlans) {
            consumptionPlanService.createConsumptionPlan(consumptionPlan);
        }
    }

	public void deleteDataBase() {
		final ArrayList<String> tables = new ArrayList<String>();
		tables.add("CONSUMPTION_PLAN");
		tables.add("HOTEL_ROOM");
		tables.add("HOTEL_ROOM_BOOKING");
		tables.add("HOTEL_ROOM_TYPE");
		tables.add("HOTELANDES_ACCOUNT_CONSUMPTION");
		tables.add("HOTELANDES_CLIENT");
		tables.add("HOTELANDES_CLIENT_ACCOUNT");
		tables.add("HOTELANDES_SERVICE");
		tables.add("HOTELANDES_USER");
		tables.add("HOTELANDES_USER_ROLE");
		tables.add("PRODUCT");
		tables.add("SERVICE_BOOKING");
		final var sql = "DELETE FROM";
		for (String s : tables) {
			jdbcTemplate.update(sql + " " + s);
		}
	}

}
