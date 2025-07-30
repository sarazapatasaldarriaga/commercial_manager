package com.commercial_manager.service;

import com.commercial_manager.models.entity.Sale;
import com.commercial_manager.models.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleServiceImpl implements ISaleService {

    @Autowired
    private ISaleRepository saleRepository;

    private static final String MESSAGE_KEY = "message";
    private static final String STATUS_KEY = "status";


    private Map<String, Object> generateError(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put(MESSAGE_KEY, message);
        response.put(STATUS_KEY, false);
        return response;
    }

    @Override
    public Map<String, Object> save(Sale sale) {
        try {
            sale.setDate(new Date());
            Sale newSale = saleRepository.save(sale);
            if (newSale != null && newSale.getId() > 0) {
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
    public Map<String, Object> update(Sale saleInput) {
        Sale sale = saleRepository.findById(saleInput.getId());
        if (sale == null) return generateError("Supplier not found.");

        try {
            sale.setId(saleInput.getId());
            sale.setItems(saleInput.getItems());
            sale.setDate(saleInput.getDate());
            sale.setClient(saleInput.getClient());
            saleRepository.save(sale);

            Map<String, Object> response = new HashMap<>();
            response.put(MESSAGE_KEY, "Supplier updated successfully");
            response.put(STATUS_KEY, true);
            return response;
        } catch (DataAccessException e) {
            return generateError("Error updating supplier.");
        }
    }

    @Override
    public Sale findById(Long id) {
        return saleRepository.findById(id);
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        saleRepository.delete(id);
        return "Supplier successfully removed";
    }


}
