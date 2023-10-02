package edu.uniandes.hotelandes.user;

public record User(
    Byte id,
    String name,
    String email,
    String idType,
    String idNumber,
    String password,
    Byte roleId) {}
