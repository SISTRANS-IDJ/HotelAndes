package edu.uniandes.hotelandes.hotel.room.hotelService.serviceBooking;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotel/room/hotelService/ServiceBooking")
public class ServiceBookingController {
    private final ServiceBookingService serviceBookingService;

    @Autowired
    public ServiceBookingController(ServiceBookingService serviceBookingService) {
        this.serviceBookingService = serviceBookingService;
    }

    @PostMapping
    public void createServiceBooking(@RequestBody ServiceBooking serviceBooking) {
        serviceBookingService.createServiceBooking(serviceBooking);
    }

    @GetMapping("{id}")
    public ServiceBooking getServiceBookingId(@PathVariable("id") Integer id) {
        return serviceBookingService.getServiceBooking(id);
    }

    @GetMapping
    public List<ServiceBooking> listServiceBookings() {
        return serviceBookingService.getServiceBookings();
    }

    @PutMapping("{id}")
    public ServiceBooking updateServiceBooking(@PathVariable Integer id, @RequestBody ServiceBooking serviceBooking) {
        return serviceBookingService.updateServiceBooking(id, serviceBooking);
    }

    @DeleteMapping("{id}")
    public void deleteServiceBooking(@PathVariable("id") Integer id) {
        serviceBookingService.deleteServiceBooking(id);
    }
}
