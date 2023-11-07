package edu.uniandes.hotelandes.account.consumption;

import edu.uniandes.hotelandes.hotel.room.service.HotelServiceService;
import java.util.Date;
import java.util.Random;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountConsumptionGenerator {

  @Autowired private HotelServiceService hotelServiceService;

  public AccountConsumption generateAccountConsumption(Faker faker) {
    Long accountId = (long) faker.number().numberBetween(1, 100);
    Long serviceId = getValidServiceId();
    Date consumptionDate = faker.date().birthday();
    String description = faker.lorem().paragraph();
    Double cost = faker.number().randomDouble(2, 0, 1000000);
    return new AccountConsumption(
        null, accountId, (long) serviceId, consumptionDate, description, cost);
  }

  private Long getValidServiceId() {
    final var services = hotelServiceService.getServices();
    Random random = new Random();
    int id = services.get(random.nextInt(services.size())).id();
    return (long) id;
  }
}
