package com.deloitte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByCustomerEmailAndCustomerPassword(String customerEmail,String customerPassword);
	Customer findByCustomerEmail(String customerEmail);
}
