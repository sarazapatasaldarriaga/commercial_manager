package com.commercial_manager.service;

import com.commercial_manager.models.entity.Client;
import com.commercial_manager.models.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    private static final String MESSAGE_KEY = "message";
    private static final String STATUS_KEY = "status";


    private Map<String, Object> generateError(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put(MESSAGE_KEY, message);
        response.put(STATUS_KEY, false);
        return response;
    }

    @Override
    public Map<String, Object> save(Client client) {
        try {
            Client newClient = clientRepository.save(client);
            if (newClient != null && newClient.getId() > 0) {
                Map<String, Object> response = new HashMap<>();
                response.put(MESSAGE_KEY, "Client successfully stored");
                response.put(STATUS_KEY, true);
                return response;
            } else {
                return generateError("Error saving Client to database");

            }
        } catch (DataAccessException e) {
            return generateError("Error saving Client to database");
        }
    }

    @Override
    public Map<String, Object> update(Client clientInput) {
        Client client = clientRepository.findById(clientInput.getId());
        if (client == null) return generateError("Client not found.");

        try {
            client.setName(clientInput.getName());
            client.setEmail(clientInput.getEmail());
            client.setPhone(clientInput.getPhone());
            clientRepository.save(client);

            Map<String, Object> response = new HashMap<>();
            response.put(MESSAGE_KEY, "Client updated successfully");
            response.put(STATUS_KEY, true);
            return response;
        } catch (DataAccessException e) {
            return generateError("Error updating Client.");
        }
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        clientRepository.delete(id);
        return "Client successfully removed";
    }

    public long countClients(){
        return clientRepository.clientCount();
    }


}
