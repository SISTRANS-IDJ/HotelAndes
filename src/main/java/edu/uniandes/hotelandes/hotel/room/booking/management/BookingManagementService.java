package edu.uniandes.hotelandes.hotel.room.booking.management;

import edu.uniandes.hotelandes.exception.NotFoundException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingManagementService {
  private final BookingManagementDAO bookingManagementDAO;

  @Autowired
  public BookingManagementService(BookingManagementDAO bookingManagementDAO) {
    this.bookingManagementDAO = bookingManagementDAO;
  }

  public Date getCheckIn(String roomBookingId) {
    return bookingManagementDAO
        .selectCheckIn(roomBookingId)
        .orElseThrow(
            () ->
                new NotFoundException(
                    String.format("CheckIn with id %s not found", roomBookingId)));
  }

  public Date getCheckOut(String roomBookingId) {
    return bookingManagementDAO
        .selectCheckOut(roomBookingId)
        .orElseThrow(
            () ->
                new NotFoundException(
                    String.format("CheckOut with id %s not found", roomBookingId)));
  }

  public void manageClientBooking(String roomBookingId, BookingState state, Date date) {
    if (state == BookingState.CHECK_IN) {
      // TODO: create account
      bookingManagementDAO.updateCheckIn(roomBookingId, date);
    } else if (state == BookingState.CHECK_OUT) {
      // TODO: close account
      bookingManagementDAO.updateCheckOut(roomBookingId, date);
    }
  }
}
