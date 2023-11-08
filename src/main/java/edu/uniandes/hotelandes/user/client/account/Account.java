package edu.uniandes.hotelandes.user.client.account;

public record Account(
    Integer id,
    Integer room_booking_id,
    Double total,
    Double balance,
    State state
) {   
}