package com.demo.smartshop.repository;
import com.demo.smartshop.dao.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepositoryIntf extends JpaRepository<UsersEntity,Long> {

}
