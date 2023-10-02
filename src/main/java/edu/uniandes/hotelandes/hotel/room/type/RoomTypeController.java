package edu.uniandes.hotelandes.hotel.room.type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("api/v1/hotel/roomtype")
public class RoomTypeController {
    private final RoomTypeService roomTypeService;
    
    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createRoomType(@RequestBody RoomType roomType) {
        
        roomTypeService.createRoomType(roomType);
    }

    @GetMapping("{id}")
    public String getRoomType(@PathVariable("id") Integer id) {
        return "hola monda";
    }

    @GetMapping()
    public List<RoomType> getRoomTypes(){
        return roomTypeService.getRoomTypes();
    }
    
}
