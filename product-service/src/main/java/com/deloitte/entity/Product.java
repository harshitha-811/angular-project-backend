package com.deloitte.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table
public class Product {
	
	@Id
	@TableGenerator(name="prodid_gen",table="tbl_prod_id",pkColumnName="pid",valueColumnName="pid_col_val",pkColumnValue="pid_val",initialValue=100,allocationSize=1)
	@GeneratedValue(generator="prodtid_gen", strategy=GenerationType.TABLE)
	private long productId;
	private String productName;
	private String description;
	private double price;
	private String imageUrl;
	
	Product(){}
	
	public Product(long productId, String productName, String description, double price, String imageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	public Product(String productName, String description, double price, String imageUrl) {
		super();
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
