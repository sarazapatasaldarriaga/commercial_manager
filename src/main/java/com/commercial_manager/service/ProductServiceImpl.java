package com.commercial_manager.service;

import com.commercial_manager.models.entity.Product;
import com.commercial_manager.models.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    private static final String MESSAGE_KEY = "message";
    private static final String STATUS_KEY = "status";


    private Map<String, Object> generateError(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put(MESSAGE_KEY, message);
        response.put(STATUS_KEY, false);
        return response;
    }

    @Override
    public Map<String, Object> save(Product product) {
        try {
            Product newProduct = productRepository.save(product);
            if (newProduct != null && newProduct.getId() > 0) {
                Map<String, Object> response = new HashMap<>();
                response.put(MESSAGE_KEY, "Product successfully stored");
                response.put(STATUS_KEY, true);
                return response;
            } else {
                return generateError("Error saving Product to database");

            }
        } catch (DataAccessException e) {
            return generateError("Error saving Product to database");
        }
    }

    @Override
    public Map<String, Object> update(Product productInput) {
        Product product = productRepository.findById(productInput.getId());
        if (product == null) return generateError("Product not found.");

        try {
            product.setName(productInput.getName());
            product.setPrice(productInput.getPrice());
            product.setStock(productInput.getStock());
            product.setSupplier(productInput.getSupplier());
            productRepository.save(product);

            Map<String, Object> response = new HashMap<>();
            response.put(MESSAGE_KEY, "Product updated successfully");
            response.put(STATUS_KEY, true);
            return response;
        } catch (DataAccessException e) {
            return generateError("Error updating Product.");
        }
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        productRepository.delete(id);
        return "Product successfully removed";
    }

    public long countProducts(){
        return productRepository.productCount();
    }


}
