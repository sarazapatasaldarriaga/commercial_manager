package com.commercial_manager.service;

import com.commercial_manager.models.entity.Supplier;
import com.commercial_manager.models.repository.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private ISupplierRepository supplierRepository;

    private static final String MESSAGE_KEY = "message";
    private static final String STATUS_KEY = "status";


    private Map<String, Object> generateError(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put(MESSAGE_KEY, message);
        response.put(STATUS_KEY, false);
        return response;
    }

    @Override
    public Map<String, Object> save(Supplier supplier) {
        try {
            supplier.setDate(new Date());
            Supplier newSupplier = supplierRepository.save(supplier);
            if (newSupplier != null && newSupplier.getId() > 0) {
                Map<String, Object> response = new HashMap<>();
                response.put(MESSAGE_KEY, "Supplier successfully stored");
                response.put(STATUS_KEY, true);
                return response;
            } else {
                return generateError("Error saving supplier to database");

            }
        } catch (DataAccessException e) {
            return generateError("Error saving supplier to database");
        }
    }

    @Override
    public Map<String, Object> update(Supplier supplierInput) {
        Supplier supplier = supplierRepository.findById(supplierInput.getId());
        if (supplier == null) return generateError("Supplier not found.");

        try {
            supplier.setName(supplierInput.getName());
            supplier.setAddress(supplierInput.getAddress());
            supplier.setPhone(supplierInput.getPhone());
            supplierRepository.save(supplier);

            Map<String, Object> response = new HashMap<>();
            response.put(MESSAGE_KEY, "Supplier updated successfully");
            response.put(STATUS_KEY, true);
            return response;
        } catch (DataAccessException e) {
            return generateError("Error updating supplier.");
        }
    }

    @Override
    public Supplier findById(Long id) {
        return supplierRepository.findById(id);
    }
}
