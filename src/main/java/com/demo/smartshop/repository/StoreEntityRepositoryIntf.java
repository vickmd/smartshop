package com.demo.smartshop.repository;
import com.demo.smartshop.dao.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreEntityRepositoryIntf extends JpaRepository<StoreEntity,Long> {

}
