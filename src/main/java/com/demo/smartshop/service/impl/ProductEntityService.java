package com.demo.smartshop.service.impl;

import com.demo.smartshop.dao.entity.ProductEntity;
import com.demo.smartshop.repository.ProductEntityRepositoryIntf;
import com.demo.smartshop.service.ProductServiceIntf;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProductEntityService implements ProductServiceIntf {

    @Autowired
    ProductEntityRepositoryIntf productEntityRepositoryIntf;

    @Override
    public ProductEntity save(ProductEntity entity) {
        return productEntityRepositoryIntf.save(entity);
    }

    @Override
    public ProductEntity update(ProductEntity entity) {
        return productEntityRepositoryIntf.save(entity);
    }

    @Override
    public void delete(ProductEntity entity) {
        productEntityRepositoryIntf.delete(entity);
    }

    @Override
    public Optional<ProductEntity> find(Long id) {
        return  productEntityRepositoryIntf.findById(id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productEntityRepositoryIntf.findAll();
    }
}
