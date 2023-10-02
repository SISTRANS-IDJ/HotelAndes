package edu.uniandes.hotelandes.hotel.room.type;

public record RoomType(
    Integer id, String name,String description, Double pricePerNight, Short capacity) {}
