package edu.uniandes.hotelandes.hotel.room.booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

import edu.uniandes.hotelandes.hotel.consumptionPlan.ConsumptionPlan;
import edu.uniandes.hotelandes.hotel.consumptionPlan.ConsumptionPlanService;
import edu.uniandes.hotelandes.hotel.room.Room;
import edu.uniandes.hotelandes.hotel.room.RoomService;
import edu.uniandes.hotelandes.user.client.Client;
import edu.uniandes.hotelandes.user.client.ClientService;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Service
public class BookingGenerator {

    private ClientService clientService;

    private RoomService roomService;

    private ConsumptionPlanService consumptionPlanService;

    private PodamFactory factory = new PodamFactoryImpl();
    private Random rand = new Random();
    private List<Client> clients ;
    private List<Room> rooms ;
    private List<ConsumptionPlan> plans ;
    private Boolean first = true;

    @Autowired
    public BookingGenerator(ClientService clientService, RoomService roomService,
            ConsumptionPlanService consumptionPlanService) {
        this.clientService = clientService;
        this.roomService = roomService;
        this.consumptionPlanService = consumptionPlanService;
        // getRequirements(clientService, roomService, consumptionPlanService);
    }

    private void getRequirements() {
        clients = this.clientService.getClients();
        rooms = this.roomService.getRooms();
        plans = this.consumptionPlanService.getConsumptionPlans();
    }

    private Integer getValidClientID() {
        Integer id = clients.get(this.rand.nextInt(clients.size())).id();
        return id;
    }

    private Integer getValidRoomID() {
        Integer id = rooms.get(this.rand.nextInt(rooms.size())).id();
        return id;
    }

    private Integer getValidPlanID() {
        Integer id = plans.get(this.rand.nextInt(plans.size())).id();
        return id;
    }

    public RoomBooking generateRoomBooking() {
        if (first){
            this.getRequirements();
            this.first = false;
        }
        Integer clientId = this.getValidClientID();
        Integer hotelRoomId = this.getValidRoomID();
        Integer consumptionPlanId = this.getValidPlanID();
        LocalDate checkIn = factory.manufacturePojo(LocalDate.class);
        LocalDate checkOut = factory.manufacturePojo(LocalDate.class);
        RoomBooking newBooking = new RoomBooking((Integer)0,clientId, hotelRoomId, checkIn, checkOut, consumptionPlanId);
        return newBooking;
    }

}
