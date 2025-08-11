package com.commercial_manager.models.repository;

import com.commercial_manager.models.dao.IProductDao;
import com.commercial_manager.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductRepositoryImpl implements IProductRepository {


    @Autowired
    private IProductDao productDao;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) productDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Product save(Product Product) {
        return productDao.save(Product);
    }

    public void delete(Long id) {
        productDao.deleteById(id);
    }

    public long productCount() {
        return productDao.productCount();
    }
}
