package com.demo.smartshop.service.impl;

import com.demo.smartshop.dao.entity.ProductStoreEntity;
import com.demo.smartshop.repository.ProductStoreEntityRepositoryIntf;
import com.demo.smartshop.service.ProductStoreServiceIntf;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProductStoreEntityService implements ProductStoreServiceIntf {

    @Autowired
    ProductStoreEntityRepositoryIntf productStoreEntityRepositoryIntf;

    @Override
    public ProductStoreEntity save(ProductStoreEntity entity) {
        return productStoreEntityRepositoryIntf.save(entity);
    }

    @Override
    public ProductStoreEntity update(ProductStoreEntity entity) {
        return productStoreEntityRepositoryIntf.save(entity);
    }

    @Override
    public void delete(ProductStoreEntity entity) {
        productStoreEntityRepositoryIntf.delete(entity);
    }

    @Override
    public Optional<ProductStoreEntity> find(Long id) {
        return productStoreEntityRepositoryIntf.findById(id);
    }

    @Override
    public List<ProductStoreEntity> findAll() {
        return productStoreEntityRepositoryIntf.findAll();
    }
}
