package edu.uniandes.hotelandes.hotel.room.service;

import java.util.Date;

public record HotelService(
    Integer id,
    String name,
    String description,
    String openingTime,
    String closingTime) {}
