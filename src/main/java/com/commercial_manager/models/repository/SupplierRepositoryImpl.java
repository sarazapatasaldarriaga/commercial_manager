package com.commercial_manager.models.repository;

import com.commercial_manager.models.dao.ISupplierDao;
import com.commercial_manager.models.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierRepositoryImpl implements ISupplierRepository {


    @Autowired
    private ISupplierDao supplierDao;

    @Override
    @Transactional(readOnly = true)
    public List<Supplier> findAll() {
        return (List<Supplier>) supplierDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Supplier findById(Long id) {
        return supplierDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Supplier save(Supplier supplier) {
        return supplierDao.save(supplier);
    }

    public void delete(Long id) {
        supplierDao.deleteById(id);
    }

    public long supplierCount() {
        return supplierDao.supplierCount();
    }

}
