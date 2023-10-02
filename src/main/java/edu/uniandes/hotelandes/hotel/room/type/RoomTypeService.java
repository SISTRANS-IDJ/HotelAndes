package edu.uniandes.hotelandes.hotel.room.type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeService {
    private final RoomTypeDao roomTypeDao;

    @Autowired
    public RoomTypeService(RoomTypeDao roomTypeDao) {
        this.roomTypeDao = roomTypeDao;
    }

    public void createRoomType(RoomType roomType) {
        final var r  = roomTypeDao.insertRoomType(roomType);
        if (r != 1) {
            throw new IllegalStateException("RoomType creation went wrong");
        }
    }

    public RoomType getRoomType(Integer id) {
        return roomTypeDao.selectRoomTypeById(id).get();
    }

    public List<RoomType> getRoomTypes() {
        return roomTypeDao.selectRoomTypes();
    }


}
