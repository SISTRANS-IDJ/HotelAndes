package edu.uniandes.hotelandes.hotel.room.hotelService;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class HotelServiceRowMapper implements RowMapper<HotelService>{
    @Override
    public HotelService mapRow(ResultSet rs, int i) throws SQLException {
        return new HotelService(rs.getInt("id"), rs.getString("name"), rs.getByte("hotel_id"), rs.getString("description"), rs.getDate("opening_time"), rs.getDate("closing_time"));
    }
    
}
