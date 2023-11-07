package edu.uniandes.hotelandes.hotel.room;

import edu.uniandes.hotelandes.hotel.room.type.RoomType;
import edu.uniandes.hotelandes.hotel.room.type.RoomTypeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomGenerator {

  private RoomTypeService roomTypeService;

  private ArrayList<Integer> roomTypes = new ArrayList<Integer>();

  private Random rand = new Random();

  @Autowired
  public RoomGenerator(RoomTypeService roomTypeService) {
    this.roomTypeService = roomTypeService;
  }

  private Integer getValidRoomTypeID() {
    Integer id = roomTypes.get(this.rand.nextInt(roomTypes.size()));
    return id;
  }

  public ArrayList<Room> generateRooms() {
    ArrayList<Room> generatedRooms = new ArrayList<Room>();
    if (this.roomTypes.size() == 0) {
      List<RoomType> roomTs = roomTypeService.getRoomTypes();
      for (RoomType r : roomTs) {
        this.roomTypes.add(r.id());
      }
    }

    for (int floor = 1; floor <= 20; floor++) {
      for (int room_num = 1; room_num <= 400; room_num++) {
        String name = floor + "-" + String.format("%3" + "s", room_num).replace(' ', '0');
        Integer roomTypeId = this.getValidRoomTypeID();
        Room thisRoom = new Room(null, name, roomTypeId);
        generatedRooms.add(thisRoom);
      }
    }
    return generatedRooms;
  }
}
