package com.demo.smartshop.service.impl;

import com.demo.smartshop.dao.entity.OrderDetailsEntity;
import com.demo.smartshop.repository.OrderDetailsEntityRepositoryIntf;
import com.demo.smartshop.service.OrderDetailsServiceIntf;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class OrderDetailsEntityService implements OrderDetailsServiceIntf {

    @Autowired
    OrderDetailsEntityRepositoryIntf orderDetailsEntityRepositoryIntf;

    @Override
    public OrderDetailsEntity save(OrderDetailsEntity entity) {
        return orderDetailsEntityRepositoryIntf.save(entity);
    }

    @Override
    public OrderDetailsEntity update(OrderDetailsEntity entity) {
        return orderDetailsEntityRepositoryIntf.save(entity);
    }

    @Override
    public void delete(OrderDetailsEntity entity) {
        orderDetailsEntityRepositoryIntf.delete(entity);
    }

    @Override
    public Optional<OrderDetailsEntity> find(Long id) {
        return orderDetailsEntityRepositoryIntf.findById(id);
    }

    @Override
    public List<OrderDetailsEntity> findAll() {
        return orderDetailsEntityRepositoryIntf.findAll();
    }
}
