package edu.uniandes.hotelandes.hotel.room.booking;

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


@Service
public class BookingGenerator {
    
    @Autowired
    private ClientService clientService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ConsumptionPlanService consumptionPlanService;
    
    private Random rand = new Random();
    private List<Client> clients =  clientService.getClients();
    private List<Room> rooms = roomService.getRooms();
    private List<ConsumptionPlan> plans = consumptionPlanService.getConsumptionPlans();

    private Integer getValidClientID(){
        Integer id = clients.get(this.rand.nextInt(clients.size())).id();
        return id;
    }

    private Integer getValidRoomID(){
        Integer id = rooms.get(this.rand.nextInt(rooms.size())).id();
        return id;
    }

    private Integer getValidPlanID(){
        Integer id = plans.get(this.rand.nextInt(plans.size())).id();
        return id;
    }

    public RoomBooking generateRoomBooking(){
        Integer clientId = this.getValidClientID();
        Integer hotelRoomId = this.getValidRoomID();
        Integer consumptionPlanId = this.getValidPlanID();
    }

}
