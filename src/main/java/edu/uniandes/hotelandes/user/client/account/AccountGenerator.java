package edu.uniandes.hotelandes.user.client.account;

import edu.uniandes.hotelandes.hotel.room.booking.RoomBooking;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uniandes.hotelandes.hotel.room.booking.RoomBookingService;

import java.util.List;
import java.util.Random;

@Service
public class AccountGenerator {

    @Autowired
    private RoomBookingService roomBookingService;

    public Account generateAccount(Faker faker) {
        int roomBookingId = getValidRoomBookingId();
        Double total = faker.number().randomDouble(2, 0, 1000000);
        Double balance = faker.number().randomDouble(2, 0, 1000000);
        String state = faker.options().option("OPEN", "CLOSED");
        return new Account(0, roomBookingId, total, balance, State.valueOf(state));
    }
    
    private Integer getValidRoomBookingId() {
        List<RoomBooking> roomBookings = roomBookingService.getRoomBookings();
        Random random = new Random();
        Integer id = roomBookings.get(random.nextInt(roomBookings.size())).id();
        return id;
    }

}
