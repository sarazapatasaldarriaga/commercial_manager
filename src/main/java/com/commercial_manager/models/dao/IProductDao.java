package com.commercial_manager.models.dao;

import com.commercial_manager.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductDao extends JpaRepository<Product, Long> {

    @Query("SELECT COUNT(p) FROM Product p")
    long productCount();
}
