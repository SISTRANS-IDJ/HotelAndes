package edu.uniandes.hotelandes.hotel.room.hotelService.product;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<Product>{
    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        return new Product(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getFloat("cost"), rs.getByte("serviceId"));
    }
}
