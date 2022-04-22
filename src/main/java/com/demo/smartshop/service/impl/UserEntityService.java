package com.demo.smartshop.service.impl;

import com.demo.smartshop.dao.entity.UsersEntity;
import com.demo.smartshop.repository.UserEntityRepositoryIntf;
import com.demo.smartshop.service.UserServiceIntf;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UserEntityService implements UserServiceIntf {

    @Autowired
    UserEntityRepositoryIntf userEntityRepositoryIntf;

    @Override
    public UsersEntity save(UsersEntity entity) {
        return userEntityRepositoryIntf.save(entity);
    }

    @Override
    public UsersEntity update(UsersEntity entity) {
        return userEntityRepositoryIntf.save(entity);
    }

    @Override
    public void delete(UsersEntity entity) {
        userEntityRepositoryIntf.delete(entity);
    }

    @Override
    public Optional<UsersEntity> find(Long id) {
        return  userEntityRepositoryIntf.findById(id);
    }

    @Override
    public List<UsersEntity> findAll() {
        return userEntityRepositoryIntf.findAll();
    }
}
