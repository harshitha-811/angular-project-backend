package com.deloitte.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table
public class Customer {
	@Id
	@TableGenerator(name="custid_gen",table="tbl_cust_id",pkColumnName="cid",valueColumnName="cid_col_val",pkColumnValue="cid_val",initialValue=20230,allocationSize=1)
	@GeneratedValue(generator="custid_gen", strategy=GenerationType.TABLE)
	private long customerId;
	private String customerEmail;
	private String customerPassword;
	
	
	public Customer(long customerId, String customerEmail, String customerPassword) {
		super();
		this.customerId = customerId;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}
	public Customer() {
		
	}
	public Customer(String customerEmail, String customerPassword) {
		super();
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	

}
