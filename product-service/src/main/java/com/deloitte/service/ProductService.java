package com.deloitte.service;

import java.util.List;

import com.deloitte.entity.Product;
import com.deloitte.entity.ProductInCart;

public interface ProductService {
	Product addProduct(Product product);
	boolean getByName(String productName);
	List<Product> viewAllProducts();
	boolean deleteProduct(long id);
	Product viewById(long id);
	Product getByProductName(String prouductName);
	ProductInCart getProdByProdId(long productId); 
}
