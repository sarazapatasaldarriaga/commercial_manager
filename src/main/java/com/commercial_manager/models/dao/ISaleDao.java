package com.commercial_manager.models.dao;

import com.commercial_manager.models.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleDao extends JpaRepository<Sale, Long> {
}
