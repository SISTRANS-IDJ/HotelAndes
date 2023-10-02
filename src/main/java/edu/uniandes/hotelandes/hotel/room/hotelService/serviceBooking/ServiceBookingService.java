package edu.uniandes.hotelandes.hotel.room.hotelService.serviceBooking;

import edu.uniandes.hotelandes.exception.NotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBookingService {
    private final ServiceBookingDAO serviceBookingDAO;

    @Autowired
    public ServiceBookingService(ServiceBookingDAO serviceBookingDAO) {
        this.serviceBookingDAO = serviceBookingDAO;
    }

    public void createServiceBooking(ServiceBooking serviceBooking) {
        final var r = serviceBookingDAO.insertServiceBooking(serviceBooking);
        if (r != 1) {
            throw new IllegalStateException("ServiceBooking creation went wrong");
        }
    }

    public ServiceBooking getServiceBooking(Integer id) {
        return serviceBookingDAO
                .selectServiceBookingById(id)
                .orElseThrow(() -> new NotFoundException(String.format("ServiceBooking with id %s not found", id)));
    }

    public List<ServiceBooking> getServiceBookings() {
        return serviceBookingDAO.selectServiceBookings();
    }

    public ServiceBooking updateServiceBooking(Integer id, ServiceBooking serviceBooking) {
        final var serviceBookings = serviceBookingDAO.selectServiceBookingById(serviceBooking.id());
        if (serviceBookings.isPresent()) {
            final var r = serviceBookingDAO.updateServiceBooking(id, serviceBooking);
            if (r != 1) {
                throw new IllegalStateException("ServiceBooking update went wrong");
            }
            return serviceBooking;
        } else {
            throw new IllegalStateException("ServiceBooking doesn't exists");
        }
    }

    public void deleteServiceBooking(Integer id) {
        final var serviceBookings = serviceBookingDAO.selectServiceBookingById(id);
        serviceBookings.ifPresentOrElse(
                serviceBooking -> {
                    final var result = serviceBookingDAO.deleteServiceBooking(id);
                    if (result != 1) {
                        throw new IllegalStateException("Could not delete serviceBooking");
                    }
                },
                () -> {
                    throw new NotFoundException(String.format("ServiceBooking with id %s not found", id));
                });
    }
    
}
