package com.demo.smartshop.service.impl;

import com.demo.smartshop.dao.entity.OrderEntity;
import com.demo.smartshop.repository.OrderEntityRepositoryIntf;
import com.demo.smartshop.service.OrderServiceIntf;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class OrderEntityService implements OrderServiceIntf {

    @Autowired
    OrderEntityRepositoryIntf orderEntityRepositoryIntf;

    @Override
    public OrderEntity save(OrderEntity entity) {
        return orderEntityRepositoryIntf.save(entity);
    }

    @Override
    public OrderEntity update(OrderEntity entity) {
        return orderEntityRepositoryIntf.save(entity);
    }

    @Override
    public void delete(OrderEntity entity) {
        orderEntityRepositoryIntf.delete(entity);
    }

    @Override
    public Optional<OrderEntity> find(Long id) {
        return orderEntityRepositoryIntf.findById(id);
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderEntityRepositoryIntf.findAll();
    }
}
