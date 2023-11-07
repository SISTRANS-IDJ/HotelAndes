package edu.uniandes.hotelandes.user.client.account;

public record Account(
    Integer id,
    Float total,
    Float balance,
    Integer clientId
) {
    
}
