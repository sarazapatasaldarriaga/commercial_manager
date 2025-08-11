package com.commercial_manager.service;

import com.commercial_manager.models.entity.Supplier;

import java.util.List;
import java.util.Map;

public interface ISupplierService {

   Map<String, Object> save(Supplier Supplier);

    Map<String, Object> update(Supplier Supplier);

    Supplier findById(Long id);

    List<Supplier> findAll();

    String delete(Long id);

    long countSupplier();

}
