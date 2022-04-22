package com.demo.smartshop.repository;
import com.demo.smartshop.dao.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntityRepositoryIntf extends JpaRepository<OrderEntity,Long> {

}
