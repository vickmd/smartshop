package com.demo.smartshop.service.impl;

import com.demo.smartshop.dao.entity.StoreEntity;
import com.demo.smartshop.repository.StoreEntityRepositoryIntf;
import com.demo.smartshop.service.StoreServiceIntf;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class StoreEntityService implements StoreServiceIntf {

    @Autowired
    StoreEntityRepositoryIntf storeEntityRepositoryIntf;

    @Override
    public StoreEntity save(StoreEntity entity) {
        return storeEntityRepositoryIntf.save(entity);
    }

    @Override
    public StoreEntity update(StoreEntity entity) {
        return storeEntityRepositoryIntf.save(entity);
    }

    @Override
    public void delete(StoreEntity entity) {
        storeEntityRepositoryIntf.delete(entity);
    }

    @Override
    public Optional<StoreEntity> find(Long id) {
        return  storeEntityRepositoryIntf.findById(id);
    }

    @Override
    public List<StoreEntity> findAll() {
        return storeEntityRepositoryIntf.findAll();
    }
}
