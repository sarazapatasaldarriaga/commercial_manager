package com.commercial_manager.service;

import com.commercial_manager.models.entity.Sale;
import com.commercial_manager.models.entity.Supplier;

import java.util.List;
import java.util.Map;

public interface ISaleService {

   Map<String, Object> save(Sale sale);

    Map<String, Object> update(Sale sale);

    Sale findById(Long id);

    List<Sale> findAll();

    String delete(Long id);

    long countSale();

}
