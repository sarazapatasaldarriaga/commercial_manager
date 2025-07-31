package com.commercial_manager.models.repository;

import com.commercial_manager.models.dao.ISaleDao;
import com.commercial_manager.models.entity.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleRepositoryImpl implements ISaleRepository {


    @Autowired
    private ISaleDao saleDao;

    @Override
    @Transactional(readOnly = true)
    public List<Sale> findAll() {
        return (List<Sale>) saleDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Sale findById(Long id) {
        return saleDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Sale save(Sale sale) {
        return saleDao.save(sale);
    }

    public void delete(Long id) {
        saleDao.deleteById(id);
    }

}
