package edu.uniandes.hotelandes.hotel.room.hotelService.serviceBooking;

import edu.uniandes.hotelandes.hotel.room.service.HotelServiceService;
import edu.uniandes.hotelandes.user.UserService;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class ServiceBookingGenerator {

        @Autowired
        private HotelServiceService hotelServiceService;

        @Autowired
        private UserService userService;

        public ServiceBooking generateServiceBooking(Faker faker) {
            Date bookingStart = faker.date().birthday();
            Date bookingEnd = faker.date().birthday();
            Byte serviceId = (byte) getValidServiceId();
            Byte userId = (byte) getValidUserId();
            return new ServiceBooking(null, bookingStart, bookingEnd, serviceId, userId);

        }

        private int getValidServiceId() {
            final var services = hotelServiceService.getServices();
            Random random = new Random();
            int id = services.get(random.nextInt(services.size())).id();
            return id;
        }

        private int getValidUserId() {
            final var users = userService.getUsers();
            Random random = new Random();
            int id = users.get(random.nextInt(users.size())).id();
            return id;
        }
}
