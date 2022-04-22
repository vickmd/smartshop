package com.demo.smartshop.repository;
import com.demo.smartshop.dao.entity.ProductStoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStoreEntityRepositoryIntf extends JpaRepository<ProductStoreEntity,Long> {

}
