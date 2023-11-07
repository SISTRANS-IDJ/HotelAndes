package edu.uniandes.hotelandes.hotel.room.type;

public enum RoomTypes {
  PRESIDENTIALSUITE("Suite presidencial", 8),
  SUITE("Suite", 6),
  FAMILY("Familiar", 6),
  DOUBLE("Doble", 3),
  SINGLE("Sencilla", 1);

  private String value;
  private int capacity;

  public String getValue() {
    return value;
  }

  public int getCapacity() {
    return capacity;
  }

  RoomTypes(String valueArg, int capacityArg) {
    value = valueArg;
    capacity = capacityArg;
  }
}
