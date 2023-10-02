package edu.uniandes.hotelandes.hotel.room.service;

import java.util.List;
import java.util.Optional;

public interface HotelServiceDAO {
  int insertService(HotelService service);

  Optional<HotelService> selectServiceById(int id);

  List<HotelService> selectServices();

  int updateService(int id, HotelService service);

  int deleteService(int id);
}
