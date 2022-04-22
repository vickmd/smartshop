package com.demo.smartshop.repository;
import com.demo.smartshop.dao.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsEntityRepositoryIntf extends JpaRepository<OrderDetailsEntity,Long> {

}
