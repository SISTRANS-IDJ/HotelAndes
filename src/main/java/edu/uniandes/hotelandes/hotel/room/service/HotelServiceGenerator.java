package edu.uniandes.hotelandes.hotel.room.service;

import net.datafaker.Faker;

import java.util.ArrayList;

public class HotelServiceGenerator {

    static public ArrayList<HotelService> generateHotelServices(Faker faker){
        ArrayList<HotelService> services = new ArrayList<HotelService>();
        String description = faker.lorem().paragraph();
        HotelService pool = new HotelService(null, Services.POOL.name(), description, "08:00","18:00");
        services.add(pool);
        description = faker.lorem().paragraph();
        HotelService gym = new HotelService(null, Services.GYM.name(), description, "07:00","22:00");
        services.add(gym);
        description = faker.lorem().paragraph();
        HotelService internet = new HotelService(null, Services.INTERNET.name(), description, "00:00","24:00");
        services.add(internet);
        description = faker.lorem().paragraph();
        HotelService bar = new HotelService(null, Services.BAR.name(), description, "17:00","05:00");
        services.add(bar);
        description = faker.lorem().paragraph();
        HotelService restaurant = new HotelService(null, Services.RESTAURANT.name(), description, "07:00","20:00");
        services.add(restaurant);
        description = faker.lorem().paragraph();
        HotelService market = new HotelService(null, Services.MARKET.name(), description, "10:00","18:00");
        services.add(market);
        description = faker.lorem().paragraph();
        HotelService grocery = new HotelService(null, Services.GROCERY.name(), description, "08:00","17:00");
        services.add(grocery);
        description = faker.lorem().paragraph();
        HotelService spa = new HotelService(null, Services.SPA.name(), description, "10:00","18:00");
        services.add(spa);
        description = faker.lorem().paragraph();
        HotelService cleaning = new HotelService(null, Services.CLEANING.name(), description, "09:00","16:00");
        services.add(cleaning);
        description = faker.lorem().paragraph();
        HotelService utensils = new HotelService(null, Services.UTENSILS.name(), description, "08:00","17:00");
        services.add(utensils);
        description = faker.lorem().paragraph();
        HotelService rooms = new HotelService(null, Services.ROOMS.name(), description, "08:00","18:00");
        services.add(rooms);

        return services;
    }
}
