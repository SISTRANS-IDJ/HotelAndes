package edu.uniandes.hotelandes.hotel.room.type;

import java.util.ArrayList;
import net.datafaker.Faker;

public class RoomTypeGenerator {

<<<<<<< HEAD
  public static ArrayList<RoomType> generateBasicRoomTypes(Faker faker) {
    ArrayList<RoomType> roomTypes = new ArrayList<RoomType>();
    for (RoomTypes r : RoomTypes.values()) {
      String description = faker.lorem().paragraph();
      Double price_per_night = faker.number().randomDouble(2, 100000, 600000);
      // Short capacity = (short) faker.number().numberBetween(2, 6);
      roomTypes.add(
          new RoomType(null, r.getValue(), description, price_per_night, (short) r.getCapacity()));
=======
    public static ArrayList<RoomType> generateBasicRoomTypes(Faker faker){
        ArrayList<RoomType> roomTypes = new ArrayList<RoomType>();
        for (RoomTypes r: RoomTypes.values()){
            String description = faker.lorem().paragraph();
            Double price_per_night = faker.number().randomDouble(2, 100000, 600000);
            // Short capacity = (short) faker.number().numberBetween(2, 6);
            roomTypes.add(new RoomType(null, r.name(), description, price_per_night, (short)r.getCapacity()));
        }
        return roomTypes;
>>>>>>> feature-data-generation
    }
    return roomTypes;
  }
}
