package edu.uniandes.hotelandes.exception;

public class EntityDoesNotExists extends RuntimeException {
  public EntityDoesNotExists(String message) {
    super(message);
  }
}
