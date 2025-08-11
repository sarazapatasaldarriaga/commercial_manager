package com.commercial_manager.models.repository;

import com.commercial_manager.models.entity.Client;

import java.util.List;

public interface IClientRepository {

     List<Client> findAll();

     Client findById(Long id);

     Client save(Client Supplier);

     void delete(Long id);

     long clientCount();



}
