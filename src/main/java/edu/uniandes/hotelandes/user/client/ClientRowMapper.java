package edu.uniandes.hotelandes.user.client;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int i) throws SQLException {
        return new Client(
            rs.getInt("id")
        );
    }
}
