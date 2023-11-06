package edu.uniandes.hotelandes.hotel.room.hotelService.product;

import net.datafaker.Faker;
public class ProductGenerator {

     static public Product generateProduct(Faker faker) {
     Long id = (long) faker.number().numberBetween(1, 100);
     String name = faker.lorem().word();
     Double cost = faker.number().randomDouble(2, 0, 1000000);
     return new Product(id, name, cost);
      }
}
