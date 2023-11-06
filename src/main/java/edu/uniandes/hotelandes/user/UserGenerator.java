package edu.uniandes.hotelandes.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import edu.uniandes.hotelandes.user.role.Role;
import edu.uniandes.hotelandes.user.role.UserRoleService;
import net.datafaker.Faker;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserGenerator {

    @Autowired
    private  UserRoleService userRoleService;


    private  Byte getValidUserRoleID(){
        List<Role> roles = userRoleService.getRoles();
        Random rand = new Random();
        Byte id = roles.get(rand.nextInt(roles.size())).id();
        return id;
    }
    
    public  User generateUser(Faker faker){
        String id_type = "CC";
        String id_number = faker.number().digits(10);
        String password = faker.number().digits(20);
        String name = faker.name().firstName();
        Pattern pattern = Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE);
        String companyName =faker.company().name().toLowerCase().replaceAll("[^a-z]", "");
        // Matcher matcher = pattern.matcher(companyName);
        String email = name.toLowerCase() + "@" + faker.domain().firstLevelDomain(companyName);
        Byte role_id = getValidUserRoleID();
        User user = new User(null, name, email, id_type, id_number, password, role_id);
        return user;
    }
}
