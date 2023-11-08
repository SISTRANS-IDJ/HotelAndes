package edu.uniandes.hotelandes.hotel.room.booking;


import java.time.LocalDate;

public record RoomBooking(
    Integer id,
    Integer clientId,
    Integer hotelRoomId,
    LocalDate checkIn,
    LocalDate checkOut,
    Integer consumptionPlanId) {}
