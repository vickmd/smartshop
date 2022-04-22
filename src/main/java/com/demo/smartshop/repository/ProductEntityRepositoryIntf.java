package com.demo.smartshop.repository;
import com.demo.smartshop.dao.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepositoryIntf extends JpaRepository<ProductEntity,Long> {

}
