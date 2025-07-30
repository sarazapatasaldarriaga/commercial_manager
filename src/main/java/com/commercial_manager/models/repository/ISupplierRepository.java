package com.commercial_manager.models.repository;

import com.commercial_manager.models.entity.Supplier;

import java.util.List;

public interface ISupplierRepository {

     List<Supplier> findAll();

     Supplier findById(Long id);

     Supplier save(Supplier Supplier);

     void delete(Long id);

}
