package com.commercial_manager.models.dao;

import com.commercial_manager.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IClientDao extends JpaRepository<Client, Long> {
    @Query("SELECT COUNT(p) FROM Client p")
    long clientCount();
}