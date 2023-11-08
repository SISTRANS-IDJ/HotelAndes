package edu.uniandes.hotelandes.hotel.room.booking;

import java.util.Date;

public record RoomBooking(
    Integer id,
    Integer clientId,
    Integer hotelRoomId,
    Date checkIn,
    Date checkOut,
    Integer consumptionPlanId) {}
