package edu.uniandes.hotelandes.hotel.room.hotelService;

import java.util.Date;

public record HotelService(Integer id, String name, Byte hotelId, String description, Date openingTime, Date closingTime) {}
