package edu.uniandes.hotelandes.hotel.room.hotelService.product;

import net.datafaker.Faker;
public class ProductGenerator {

     static public Product generateProduct(Faker faker) {
     Integer id = (Integer) faker.number().numberBetween(1, 100);
     String name = faker.beer().name();
     String description = faker.lorem().word();
     Float cost = (float) faker.number().randomDouble(2, 0, 1000000);
     Byte serviceID = (byte)faker.number().randomNumber(10, false);
     return new Product(id, name, description, cost, serviceID);
      }
}
