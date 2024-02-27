package com.deloitte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	Product findByProductName(String ProductName);

}
