package edu.uniandes.hotelandes.account.consumption;

import java.util.Date;

public record AccountConsumption(Long id, Long accountId, Date consumptionDate, String description, Double cost) {
}
