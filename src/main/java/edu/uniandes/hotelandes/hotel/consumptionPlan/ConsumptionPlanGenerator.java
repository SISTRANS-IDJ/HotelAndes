package edu.uniandes.hotelandes.hotel.consumptionPlan;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


public class ConsumptionPlanGenerator {

    public static ArrayList<ConsumptionPlan> generateConusmptionPlan(Faker faker){
        ArrayList<ConsumptionPlan> consumptionPlans = new ArrayList<ConsumptionPlan>();
        String planDesc = faker.lorem().paragraph();
        ConsumptionPlan largaEstadia = new ConsumptionPlan((Integer) 1, Plans.LARGA_ESTADIA.name(), planDesc, 0.1, 0.0);
        consumptionPlans.add(largaEstadia);
        planDesc = faker.lorem().paragraph();
        ConsumptionPlan tiempoCompartido = new ConsumptionPlan((Integer) 2, Plans.TIEMPO_COMPARTIDO.name(), planDesc, 0.15,  2000.0);
        consumptionPlans.add(tiempoCompartido);
        planDesc = faker.lorem().paragraph();
        ConsumptionPlan todoIncluido = new ConsumptionPlan((Integer) 3, Plans.TODO_INCLUIDO.name(), planDesc, 0.0,  3000.0);
        consumptionPlans.add(todoIncluido);
        planDesc = faker.lorem().paragraph();
        ConsumptionPlan promocionesParticulares1 = new ConsumptionPlan((Integer) 4, Plans.PROMOCIONES_PARTICULARES.name(), planDesc, 0.5,  1000.0);
        consumptionPlans.add(promocionesParticulares1);
        planDesc = faker.lorem().paragraph();
        ConsumptionPlan promocionesParticulares2 = new ConsumptionPlan((Integer) 5, Plans.PROMOCIONES_PARTICULARES.name(), planDesc, 0.3,  3000.0);
        return consumptionPlans;
    }
}
