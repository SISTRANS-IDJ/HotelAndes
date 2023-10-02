package edu.uniandes.hotelandes.user;

public record User(
    Byte id,
    String name,
    String email,
    String id_type,
    String id_number,
    String password,
    Byte role_id) {}
