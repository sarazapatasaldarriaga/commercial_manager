package com.commercial_manager.models.repository;

import com.commercial_manager.models.dao.IClientDao;
import com.commercial_manager.models.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientRepositoryImpl implements IClientRepository {


    @Autowired
    private IClientDao clientDao;

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return (List<Client>) clientDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Client findById(Long id) {
        return clientDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Client save(Client Client) {
        return clientDao.save(Client);
    }

    public void delete(Long id) {
        clientDao.deleteById(id);
    }

    public long clientCount() {
        return clientDao.clientCount();
    }
}
