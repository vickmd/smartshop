package com.demo.smartshop.generic;

import java.util.List;
import java.util.Optional;


public interface GenericService<T extends Object> {

	T save(T entity);
    
    T update(T entity);
  
    void delete(T entity);

    Optional<T> find(Long id);
  
    List<T> findAll();
}
