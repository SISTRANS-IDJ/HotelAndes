package edu.uniandes.hotelandes.hotel.room.booking;

import java.util.Date;

public record RoomBooking(
    String id,
    Integer clientId,
    Integer hotelRoomId,
    Date checkIn,
    Date checkOut,
    Byte consumptionPlanId) {}
