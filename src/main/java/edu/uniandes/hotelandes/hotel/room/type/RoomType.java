package edu.uniandes.hotelandes.hotel.room.type;

public record RoomType(
    Integer id, String name,String description, Double price_per_night, Short capacity) {}
