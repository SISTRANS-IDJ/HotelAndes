package edu.uniandes.hotelandes.hotel.room.booking;

import java.util.List;
import java.util.Optional;

public interface RoomBookingDAO {
  int insertRoomBooking(RoomBooking roomBooking);

  Optional<RoomBooking> selectRoomBookingById(Integer id);

  List<RoomBooking> selectRoomBookings();

  int updateRoomBooking(Integer id, RoomBooking roomBooking);

  int deleteRoomBooking(Integer id);
}
