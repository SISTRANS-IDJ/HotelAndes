package edu.uniandes.hotelandes.hotel.consumptionPlan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumptionPlanService {
    private final ConsumptionPlanDAO consumptionPlanDAO;

    @Autowired
    public ConsumptionPlanService(ConsumptionPlanDAO consumptionPlanDAO) {
        this.consumptionPlanDAO = consumptionPlanDAO;
    }

    public void createConsumptionPlan(ConsumptionPlan consumptionPlan) {
        final var r = consumptionPlanDAO.insertConsumptionPlan(consumptionPlan);
        if (r != 1) {
            throw new IllegalStateException("ConsumptionPlan creation went wrong");
        }
    }

    public ConsumptionPlan getConsumptionPlan(Integer id) {
        return consumptionPlanDAO
                .selectConsumptionPlanById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("ConsumptionPlan with id %s not found", id)));
    }

    public List<ConsumptionPlan> getConsumptionPlans() {
        return consumptionPlanDAO.selectConsumptionPlans();
    }

    public ConsumptionPlan updateConsumptionPlan(Integer id, ConsumptionPlan consumptionPlan) {
        final var consumptionPlans = consumptionPlanDAO.selectConsumptionPlanById(consumptionPlan.id());
        if (consumptionPlans.isPresent()) {
            final var r = consumptionPlanDAO.updateConsumptionPlan(id, consumptionPlan);
            if (r != 1) {
                throw new IllegalStateException("ConsumptionPlan update went wrong");
            }
            return consumptionPlan;
        } else {
            throw new IllegalStateException("ConsumptionPlan doesn't exists");
        }
    }

    public void deleteConsumptionPlan(Integer id) {
        final var consumptionPlans = consumptionPlanDAO.selectConsumptionPlanById(id);
        consumptionPlans.ifPresentOrElse(
                consumptionPlan -> {
                    final var result = consumptionPlanDAO.deleteConsumptionPlan(id);
                    if (result != 1) {
                        throw new IllegalStateException("Could not delete consumptionPlan");
                    }
                },
                () -> {
                    throw new IllegalStateException(String.format("ConsumptionPlan with id %s not found", id));
                });
    }
}
