package edu.uniandes.hotelandes.dataGenerator;

import edu.uniandes.hotelandes.account.consumption.AccountConsumption;
import edu.uniandes.hotelandes.account.consumption.AccountConsumptionService;
import edu.uniandes.hotelandes.account.consumption.AccountConsumptionGenerator;
import edu.uniandes.hotelandes.user.role.Role;
import edu.uniandes.hotelandes.user.role.RoleDAO;
import edu.uniandes.hotelandes.user.role.RoleGenerator;
import edu.uniandes.hotelandes.user.role.UserRoleService;
import net.datafaker.Faker;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
class DataGeneratorService {

	private Faker faker =  new Faker();

	@Autowired
	private UserRoleService userRoleService;

	@Autowired 
	private JdbcTemplate jdbcTemplate;

	public void insertRoles() {
		ArrayList<Role> roles = RoleGenerator.generateRoles(this.faker);
		for (Role role: roles){
			userRoleService.createUserRole(role);
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
