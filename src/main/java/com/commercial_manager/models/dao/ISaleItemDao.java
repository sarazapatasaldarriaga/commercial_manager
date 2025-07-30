package com.commercial_manager.models.dao;

import com.commercial_manager.models.entity.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleItemDao extends JpaRepository<SaleItem, Long> {
}
