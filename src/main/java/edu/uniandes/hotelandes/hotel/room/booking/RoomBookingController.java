package edu.uniandes.hotelandes.hotel.room.booking;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotel/room/booking")
public class RoomBookingController {
  private final RoomBookingService roomBookingService;

  @Autowired
  public RoomBookingController(RoomBookingService roomService) {
    this.roomBookingService = roomService;
  }

  @PostMapping
  public void createRoomBooking(@RequestBody RoomBooking roomBooking) {
    roomBookingService.createRoomBooking(roomBooking);
  }

  @GetMapping("{id}")
  public RoomBooking getRoomBookingId(@PathVariable("id") Integer id) {
    return roomBookingService.getRoomBooking(id);
  }

  @GetMapping
  public List<RoomBooking> listRoomBookings() {
    return roomBookingService.getRoomBookings();
  }

  @PutMapping("{id}")
  public RoomBooking updateRoomBooking(
      @PathVariable Integer id, @RequestBody RoomBooking roomBooking) {
    return roomBookingService.updateRoom(id, roomBooking);
  }

  @DeleteMapping("{id}")
  public void deleteRoomBooking(@PathVariable("id") Integer id) {
    roomBookingService.deleteRoom(id);
  }
}
