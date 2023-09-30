package edu.uniandes.hotelandes.hotel.room.booking;

import java.util.List;
import java.util.Optional;

public interface RoomBookingDAO {
  int insertRoomBooking(RoomBooking roomBooking);

  Optional<RoomBooking> selectRoomBookingsById(String id);

  List<RoomBooking> selectRoomBookings();

  int updateRoomBooking(String id, RoomBooking roomBooking);

  int deleteRoomBooking(String id);
}
