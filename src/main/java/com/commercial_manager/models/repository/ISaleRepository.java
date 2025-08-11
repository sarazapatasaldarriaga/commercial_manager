package com.commercial_manager.models.repository;

import com.commercial_manager.models.entity.Sale;

import java.util.List;

public interface ISaleRepository {

     List<Sale> findAll();

     Sale findById(Long id);

     Sale save(Sale sale);

     void delete(Long id);

     long saleCount();


}
