package edu.uniandes.hotelandes.hotel.consumptionPlan;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/hotel/consumptionPlan")
public class ConsumptionPlanController {

  private final ConsumptionPlanService consumptionPlanService;

  @Autowired
  public ConsumptionPlanController(ConsumptionPlanService consumptionPlanService) {
    this.consumptionPlanService = consumptionPlanService;
  }

  @PostMapping
  public void createConsumptionPlan(@RequestBody ConsumptionPlan consumptionPlan) {
    consumptionPlanService.createConsumptionPlan(consumptionPlan);
  }

  @GetMapping
  public List<ConsumptionPlan> listConsumptionPlans() {
    return consumptionPlanService.getConsumptionPlans();
  }
}
