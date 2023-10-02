package edu.uniandes.hotelandes.hotel.room.booking.management;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotel/room/booking/")
public class BookingManagementController {
  private final BookingManagementService bookingManagementService;

  @Autowired
  public BookingManagementController(BookingManagementService bookingManagementService) {
    this.bookingManagementService = bookingManagementService;
  }

  @GetMapping("{id}/checkin")
  public void getCheckIn(@PathVariable("id") String roomBookingId) {
    bookingManagementService.getCheckIn(roomBookingId);
  }

  @GetMapping("{id}/checkout")
  public void getCheckOut(@PathVariable("id") String roomBookingId) {
    bookingManagementService.getCheckOut(roomBookingId);
  }

  @PutMapping("{id}/manage")
  public void manageClientBooking(
      @PathVariable("id") String roomBookingId,
      @RequestParam BookingState state,
      @RequestParam Date date) {
    bookingManagementService.manageClientBooking(roomBookingId, state, date);
  }
  // {host}/port/api/v1/hotel/room/booking/{id}/?state=TRUE
}
