package edu.uniandes.hotelandes.hotel.room.hotelService.serviceBooking;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ServiceBookingRowMapper implements RowMapper<ServiceBooking> {
    @Override
    public ServiceBooking mapRow(ResultSet rs, int i) throws SQLException {
        return new ServiceBooking(rs.getInt("id"), rs.getDate("booking_start"), rs.getDate("booking_end"), rs.getByte("service_id"), rs.getByte("user_id"));
    }
    
}
