package com.commercial_manager.service;

import com.commercial_manager.models.entity.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {

   Map<String, Object> save(Product product);

    Map<String, Object> update(Product product);

    Product findById(Long id);

    List<Product> findAll();

    String delete(Long id);

}
