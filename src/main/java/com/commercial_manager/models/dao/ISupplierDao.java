package com.commercial_manager.models.dao;

import com.commercial_manager.models.entity.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface ISupplierDao extends CrudRepository<Supplier, Long> {


}

