package edu.uniandes.hotelandes.user.client.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uniandes.hotelandes.hotel.room.booking.RoomBookingService;

@Service
public class AccountGenerator {
    private RoomBookingService roomBookingService;

    @Autowired
    public AccountGenerator(RoomBookingService roomBookingService){
        this.roomBookingService = roomBookingService;
    }

    


}
