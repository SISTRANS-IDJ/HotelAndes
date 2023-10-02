package edu.uniandes.hotelandes.hotel.room.hotelService.serviceBooking;

import java.util.Date;

public record ServiceBooking(Integer id, Date bookingStart, Date bookingEnd, Byte serviceId, Byte userId) {}
