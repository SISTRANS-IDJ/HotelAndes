package edu.uniandes.hotelandes.hotel.room.hotelService.serviceBooking;

import edu.uniandes.hotelandes.hotel.room.service.HotelServiceService;
import edu.uniandes.hotelandes.user.UserService;
import edu.uniandes.hotelandes.user.client.ClientService;
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
        private ClientService clientService;

        public ServiceBooking generateServiceBooking(Faker faker) {
            Date bookingStart = faker.date().birthday();
            Date bookingEnd = faker.date().birthday();
            Byte serviceId = (byte) getValidServiceId();
            Byte userId = (byte) getValidClientId();
            return new ServiceBooking(null, bookingStart, bookingEnd, serviceId, userId);

        }

        private int getValidServiceId() {
            final var services = hotelServiceService.getServices();
            Random random = new Random();
            int id = services.get(random.nextInt(services.size())).id();
            return id;
        }

        private int getValidClientId() {
            final var clients = clientService.getClients();
            Random random = new Random();
            int id = clients.get(random.nextInt(clients.size())).id();
            return id;
        }
}
