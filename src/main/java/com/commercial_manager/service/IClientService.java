package com.commercial_manager.service;

import com.commercial_manager.models.entity.Client;

import java.util.List;
import java.util.Map;

public interface IClientService {

   Map<String, Object> save(Client client);

    Map<String, Object> update(Client client);

    Client findById(Long id);

    List<Client> findAll();

    String delete(Long id);

    long countClients();

}
