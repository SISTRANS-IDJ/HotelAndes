package edu.uniandes.hotelandes.hotel.room.hotelService.product;

import edu.uniandes.hotelandes.hotel.room.service.HotelServiceService;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ProductGenerator {

     @Autowired
     private HotelServiceService hotelServiceService;

     public Product generateProduct(Faker faker) {
         String name = faker.beer().name();
         String description = faker.lorem().word();
         Float cost = (float) faker.number().randomDouble(2, 0, 1000000);
         Byte serviceID = (byte) getValidServiceId();
         return new Product(null, name, description, cost, serviceID);
     }

     private int getValidServiceId() {
        final var services = hotelServiceService.getServices();
        Random random = new Random();
        int id = services.get(random.nextInt(services.size())).id();
        return id;
     }
}
