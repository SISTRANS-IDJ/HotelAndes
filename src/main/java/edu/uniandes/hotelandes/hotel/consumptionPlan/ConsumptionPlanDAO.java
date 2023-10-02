package edu.uniandes.hotelandes.hotel.consumptionPlan;

import java.util.List;
import java.util.Optional;

public interface ConsumptionPlanDAO {
    int insertConsumptionPlan(ConsumptionPlan consumptionPlan);

    Optional<ConsumptionPlan> selectConsumptionPlanById(int id);
    
    List<ConsumptionPlan> selectConsumptionPlans();

    int updateConsumptionPlan(int id, ConsumptionPlan consumptionPlan);

    int deleteConsumptionPlan(int id);
}
