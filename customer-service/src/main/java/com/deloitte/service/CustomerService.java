package com.deloitte.service;

import java.util.List;

import com.deloitte.entity.Customer;

public interface CustomerService {
	Customer addCustomer(Customer customer);
	List<Customer> viewAllCustomers();
	boolean getByEmailAndPassword(String customerEmail, String customerPassword);
	boolean getByEmail(String customerEmail);
	long getCustomerByEmail(String customerEmail);
	Customer getCustByEmail(String customerEmail);

}
