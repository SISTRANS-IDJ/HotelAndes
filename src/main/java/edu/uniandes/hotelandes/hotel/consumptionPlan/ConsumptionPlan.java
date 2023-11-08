package edu.uniandes.hotelandes.hotel.consumptionPlan;

public record ConsumptionPlan(
    Integer id, String plan_name, String plan_description, Double plan_discount, Double fixed_cost) {}
