package com.commercial_manager.models.dao;

import com.commercial_manager.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientDao extends JpaRepository<Client, Long> {
}