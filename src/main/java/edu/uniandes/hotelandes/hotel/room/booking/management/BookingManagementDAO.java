package edu.uniandes.hotelandes.hotel.room.booking.management;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import edu.uniandes.hotelandes.hotel.room.booking.RoomBooking;

public interface BookingManagementDAO{

    Optional<Date> selectCheckIn(String roomBookingId);

    int updateCheckIn(String roomBookingId, Date checkIn);

    Optional<Date> selectCheckOut(String roomBookingId);

    int updateCheckOut(String roomBookingId, Date checkOut);

}
