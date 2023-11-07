package edu.uniandes.hotelandes.dataGenerator;

import edu.uniandes.hotelandes.account.consumption.AccountConsumption;
import edu.uniandes.hotelandes.account.consumption.AccountConsumptionService;
import edu.uniandes.hotelandes.hotel.room.service.HotelServiceService;
import edu.uniandes.hotelandes.hotel.room.type.RoomType;
import edu.uniandes.hotelandes.hotel.room.type.RoomTypeGenerator;
import edu.uniandes.hotelandes.hotel.room.type.RoomTypeService;
import edu.uniandes.hotelandes.account.consumption.AccountConsumptionGenerator;
import edu.uniandes.hotelandes.user.User;
import edu.uniandes.hotelandes.user.UserGenerator;
import edu.uniandes.hotelandes.user.UserService;
import edu.uniandes.hotelandes.user.role.Role;
import edu.uniandes.hotelandes.user.role.RoleDAO;
import edu.uniandes.hotelandes.user.role.RoleGenerator;
import edu.uniandes.hotelandes.user.role.UserRoleService;
import net.datafaker.Faker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.datasource.init.ScriptUtils;


@Service
class DataGeneratorService {

	private Faker faker =  new Faker();

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private HotelServiceService hotelServiceService;
	
	@Autowired
	private RoomTypeService roomTypeService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserGenerator userGenerator;

	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Autowired
    private ApplicationContext applicationContext;


	public void insertData(){
		this.insertRoles();
		this.insertRoomTypes();
		this.insertUsers();
	}

	public void createTables() throws SQLException{
		DataSource ds = (DataSource)applicationContext.getBean("dataSource");
		Connection c = ds.getConnection();
		SpringScriptUtil.runScript("sql/schema.sql",c);
	}
	
	public void dropTables() throws SQLException{
		DataSource ds = (DataSource)applicationContext.getBean("dataSource");
		Connection c = ds.getConnection();
		SpringScriptUtil.runScript("sql/tear_down.sql",c);
	}

	public void insertRoles() {
		ArrayList<Role> roles = RoleGenerator.generateRoles(this.faker);
		for (Role role: roles){
			userRoleService.createUserRole(role);
		}
	}

	public void insertRoomTypes(){
		ArrayList<RoomType> roomTypes = RoomTypeGenerator.generateBasicRoomTypes(faker);
		for (RoomType roomType:roomTypes){
			roomTypeService.createRoomType(roomType);
		}
	}

	public void insertUsers(){
		for (int i = 0; i<750000; i++){
			User user =this.userGenerator.generateUser(faker);
			this.userService.createUser(user);

		}
	}

	

	public void deleteDataBase(){
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
		for (String s:tables){
			jdbcTemplate.update(sql + " "+ s);
		}
	}

	// @Autowired
	// private AccountConsumptionGenerator accountConsumptionGenerator;

	// public void generateDataAccountConsumption(){
	// Faker faker = new Faker();
	// for(int i = 1; i < 500000; i++){
	// AccountConsumption accountConsumption =
	// accountConsumptionGenerator.generateAccountConsumption(faker);
	// AccountConsumptionService.createAccountConsumption(accountConsumption);
	// }
	// }

}
