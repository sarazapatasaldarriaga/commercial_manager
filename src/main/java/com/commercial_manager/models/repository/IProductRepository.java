package com.commercial_manager.models.repository;

import com.commercial_manager.models.entity.Product;
import com.commercial_manager.models.entity.Supplier;

import java.util.List;

public interface IProductRepository {

     List<Product> findAll();

     Product findById(Long id);

     Product save(Product Supplier);

     void delete(Long id);

}
