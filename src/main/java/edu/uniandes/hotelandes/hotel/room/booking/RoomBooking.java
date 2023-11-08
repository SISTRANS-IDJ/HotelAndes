package edu.uniandes.hotelandes.hotel.room.booking;


import java.time.LocalDate;
import java.util.Date;

public record RoomBooking(
    Integer id,
    Integer clientId,
    Integer hotelRoomId,
    Date checkIn,
    Date checkOut,
    Integer consumptionPlanId) {}
