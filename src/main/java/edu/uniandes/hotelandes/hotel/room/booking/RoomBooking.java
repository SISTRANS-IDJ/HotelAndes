package edu.uniandes.hotelandes.hotel.room.booking;

import java.util.Date;

public record RoomBooking(
    String id,
    Long clientId,
    Integer hotelRoomId,
    Date checkIn,
    Date checkOut,
    Byte capacity,
    Byte consumptionPlanId) {}
