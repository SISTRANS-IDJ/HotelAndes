package edu.uniandes.hotelandes.hotel.room.hotelService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotel/room/hotelService")
public class HotelServiceController {
    private final HotelServiceService serviceService;

    @Autowired
    public HotelServiceController(HotelServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping
    public void createService(@RequestBody HotelService service) {
        serviceService.createService(service);
    }

    @GetMapping("{id}")
    public HotelService getServiceId(@PathVariable("id") Integer id) {
        return serviceService.getService(id);
    }

    @GetMapping
    public List<HotelService> listServices() {
        return serviceService.getServices();
    }

    @PutMapping("{id}")
    public HotelService updateService(@PathVariable Integer id, @RequestBody HotelService service) {
        return serviceService.updateService(id, service);
    }

    @DeleteMapping("{id}")
    public void deleteService(@PathVariable("id") Integer id) {
        serviceService.deleteService(id);
    }
    
}
