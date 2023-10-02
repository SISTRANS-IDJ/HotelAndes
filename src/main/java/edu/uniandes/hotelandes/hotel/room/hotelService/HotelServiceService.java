package edu.uniandes.hotelandes.hotel.room.hotelService;

import edu.uniandes.hotelandes.exception.NotFoundException;
import oracle.net.aso.f;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceService {
    private final HotelServiceDAO serviceDAO;

    @Autowired
    public HotelServiceService(HotelServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    public void createService(HotelService service) {
        final var r = serviceDAO.insertService(service);
        if (r != 1) {
            throw new IllegalStateException("Service creation went wrong");
        }
    }

    public HotelService getService(Integer id) {
        return serviceDAO
                .selectServiceById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Service with id %s not found", id)));
    }

    public List<HotelService> getServices() {
        return serviceDAO.selectServices();
    }

    public HotelService updateService(Integer id, HotelService service) {
        final var services = serviceDAO.selectServiceById(service.id());
        if (services.isPresent()) {
            final var r = serviceDAO.updateService(id, service);
            if (r != 1) {
                throw new IllegalStateException("Service update went wrong");
            }
            return service;
        } else {
            throw new IllegalStateException("Service doesn't exists");
        }
    }

    public void deleteService(Integer id) {
        final var services = serviceDAO.selectServiceById(id);
        services.ifPresentOrElse(
                service -> {
                    final var result = serviceDAO.deleteService(id);
                    if (result != 1) {
                        throw new IllegalStateException("Could not delete service");
                    }
                },
                () -> {
                    throw new NotFoundException(String.format("Service with id %s not found", id));
                });
    }
}
