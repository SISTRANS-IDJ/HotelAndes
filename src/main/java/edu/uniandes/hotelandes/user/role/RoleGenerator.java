package edu.uniandes.hotelandes.user.role;

import net.datafaker.Faker;

import java.util.ArrayList;

public class RoleGenerator {

    static public ArrayList<Role> generateRoles(Faker faker) {
        ArrayList<Role> roles = new ArrayList<Role>();
        String roleDesc = faker.lorem().paragraph();
        Role role1 = new Role((Byte) (byte) 1, Roles.CLIENT.name(), roleDesc);
        roles.add(role1);
        roleDesc = faker.lorem().paragraph();
        Role role2 = new Role((Byte) (byte) 1, Roles.ADMINISTRATOR.name(), roleDesc);
        roles.add(role2);
        roleDesc = faker.lorem().paragraph();
        Role role3= new Role((Byte) (byte) 1, Roles.EMPLOYEE.name(), roleDesc);
        roles.add(role3);
        roleDesc = faker.lorem().paragraph();
        Role role4 = new Role((Byte) (byte) 1, Roles.MANAGER.name(), roleDesc);
        roles.add(role4);
        roleDesc = faker.lorem().paragraph();
        Role role5 = new Role((Byte) (byte) 1, Roles.RECEPTIONIST.name(), roleDesc);
        roles.add(role5);

        return roles;
    }
}