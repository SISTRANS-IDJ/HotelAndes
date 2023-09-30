package edu.uniandes.hotelandes.hotel.room;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotel/room")
public class RoomController {
  private final RoomService roomService;

  @Autowired
  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @PostMapping
  public void createRoom(@RequestBody Room room) {
    roomService.createRoom(room);
  }

  @GetMapping("{id}")
  public Room getRoomId(@PathVariable("id") Integer id) {
    return roomService.getRoom(id);
  }

  @GetMapping
  public List<Room> listRooms() {
    return roomService.getRooms();
  }

  @PutMapping("{id}")
  public Room updateRoom(@PathVariable Integer id, @RequestBody Room room) {
    return roomService.updateRoom(id, room);
  }

  @DeleteMapping("{id}")
  public void deleteRoom(@PathVariable("id") Integer id) {
    roomService.deleteRoom(id);
  }
}
