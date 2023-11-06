package edu.uniandes.hotelandes.hotel.room.type;

import java.util.ArrayList;
import java.util.List;

import net.datafaker.Faker;

public class RoomTypeGenerator {
    
    // public RoomType generateRoomType(Faker faker){
    //     String name;
    //     String description ;
    //     Double price_per_night;
    //     Short capacity ;

    //     return new RoomType(null, name, description, price_per_night, capacity);
    // }

    public static ArrayList<RoomType> generateBasicRoomTypes(Faker faker){
        ArrayList<RoomType> roomTypes = new ArrayList<RoomType>();
        for (RoomTypes r: RoomTypes.values()){
            String description = faker.lorem().paragraph();
            Double price_per_night = faker.number().randomDouble(2, 100000, 600000);
            // Short capacity = (short) faker.number().numberBetween(2, 6);
            roomTypes.add(new RoomType(null, r.getValue(), description, price_per_night, (short)r.getCapacity()));
        }
        return roomTypes;
    }
}
