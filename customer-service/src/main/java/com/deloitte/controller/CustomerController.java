package com.deloitte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.entity.Customer;
import com.deloitte.service.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@PostMapping("/signup")
	public String signUp(@RequestBody Customer customer) {
		if(service.getByEmail(customer.getCustomerEmail())) {	
		return "User already exists!";
	}
		long id=service.addCustomer(customer).getCustomerId();
		return "Signup sucessful! Your customer id is "+id;
	}
	
	@GetMapping("")
	public List<Customer> viewAll(){
		return service.viewAllCustomers();
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody Customer customer) {
	 return service.getByEmailAndPassword(customer.getCustomerEmail(), customer.getCustomerPassword());
	}
	
	@GetMapping("/email/{customerEmail}")
	public boolean getCustByEmail(@PathVariable String customerEmail) {
		return service.getByEmail(customerEmail);
	}
	@GetMapping("/customer/{customerEmail}")
	public Customer getCustByEmailId(@PathVariable String customerEmail) {
		return service.getCustByEmail(customerEmail);
	}
	@GetMapping("/byemail/{customerEmail}")
	public long getCustomerByEmailId(@PathVariable String customerEmail) {
		return service.getCustomerByEmail(customerEmail);
	}
}