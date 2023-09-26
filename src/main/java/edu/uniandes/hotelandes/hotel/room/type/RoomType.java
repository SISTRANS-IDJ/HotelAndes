package edu.uniandes.hotelandes.hotel.room.type;

public record RoomType(
    Short id,
    Double costPerNight,
    Short suggestedMinimumCapacity,
    Short suggestedMaximumCapacity) {}
