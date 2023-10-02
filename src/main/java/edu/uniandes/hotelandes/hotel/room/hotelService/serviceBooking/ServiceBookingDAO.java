package edu.uniandes.hotelandes.hotel.room.hotelService.serviceBooking;

import java.util.List;
import java.util.Optional;

public interface ServiceBookingDAO {
    int insertServiceBooking (ServiceBooking serviceBooking);

    Optional<ServiceBooking> selectServiceBookingById (int id);

    List<ServiceBooking> selectServiceBookings ();

    int updateServiceBooking (int id, ServiceBooking serviceBooking);

    int deleteServiceBooking (int id);
}
