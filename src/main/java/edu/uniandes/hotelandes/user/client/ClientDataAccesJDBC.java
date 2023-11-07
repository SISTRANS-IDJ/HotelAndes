package edu.uniandes.hotelandes.user.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDataAccesJDBC implements ClientDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDataAccesJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Client> selectClients() {
        final var sql = "SELECT id FROM hotelandes_client";
        return jdbcTemplate.query(sql, new ClientRowMapper());
    }
}
