package com.deloitte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.entity.Customer;
import com.deloitte.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository repo;

	@Override
	public Customer addCustomer(Customer customer) {
		return repo.save(customer);
	}

	@Override
	public List<Customer> viewAllCustomers() {
		return repo.findAll();
	}

	@Override
	public boolean getByEmailAndPassword(String customerEmail, String customerPassword) {
		Customer customer = repo.findByCustomerEmailAndCustomerPassword(customerEmail, customerPassword);
		if(customer==null) {
			return false;
		}
		else
			return true;
	}

	@Override
	public boolean getByEmail(String customerEmail) {
		Customer customer=repo.findByCustomerEmail(customerEmail);
		if(customer!=null) {
			return true;
		}
		return false;
	}

	@Override
	public long getCustomerByEmail(String customerEmail) {
		Customer customer= repo.findByCustomerEmail(customerEmail);
		return customer.getCustomerId();
	}

	@Override
	public Customer getCustByEmail(String customerEmail) {
		return repo.findByCustomerEmail(customerEmail);
	}
	
	
	

}