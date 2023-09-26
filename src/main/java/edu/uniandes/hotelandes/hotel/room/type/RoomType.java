package edu.uniandes.hotelandes.hotel.room.type;

public record RoomType(
    Byte id, Double costPerNight, Short suggestedMinimumCapacity, Short suggestedMaximumCapacity) {}
