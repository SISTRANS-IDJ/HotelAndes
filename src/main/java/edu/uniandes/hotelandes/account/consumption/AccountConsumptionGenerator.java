package edu.uniandes.hotelandes.account.consumption;

import java.util.Date;
import edu.uniandes.hotelandes.hotel.room.service.HotelServiceService;
import edu.uniandes.hotelandes.hotel.room.service.HotelServiceDAO;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountConsumptionGenerator {

        @Autowired
        private HotelServiceService hotelServiceService;
        public AccountConsumption generateAccountConsumption(Faker faker) {
            boolean sentinela = true;
            Long accountId = (long) faker.number().numberBetween(1, 100);
            Integer id = 0;
            while (sentinela) {
                Integer serviceId = faker.number().positive();
                if (hotelServiceService.getService(serviceId) != null) {
                    sentinela = false;
                    id = serviceId;
                }
            }
            Date consumptionDate = faker.date().birthday();
            String description = faker.lorem().paragraph();
            Double cost = faker.number().randomDouble(2, 0, 1000000);
            return new AccountConsumption( null, accountId, (long) id, consumptionDate, description, cost);
        }
}
