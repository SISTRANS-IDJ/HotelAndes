package edu.uniandes.hotelandes.user.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientDAO clientDAO;

    @Autowired
    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public List<Client> getClients() {
        return clientDAO.selectClients();
    }
    
}
