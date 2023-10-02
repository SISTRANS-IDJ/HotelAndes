package edu.uniandes.hotelandes.account.consumption;

import java.util.Date;

public record AccountConsumption(
    Long id,
    Long accountId,
    Long serviceId,
    Date consumptionDate,
    String description,
    Double cost) {}
