package com.commercial_manager.models.dao;

import com.commercial_manager.models.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ISaleDao extends JpaRepository<Sale, Long> {
    @Query("SELECT COUNT(p) FROM Sale p")
    long saleCount();
}
