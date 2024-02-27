package com.deloitte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.entity.Product;
import com.deloitte.entity.ProductInCart;
import com.deloitte.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@PostMapping("/add")
	public boolean add(@RequestBody Product product) {
		if(product.getProductId()!=0) {
			Product prod1=service.addProduct(product);
			return true;
		}
		if(service.getByName(product.getProductName())) {
			return false;
		}
		Product prod=service.addProduct(product);
		if(prod!=null) {
			return true;
		}
	return false;
	}
	@GetMapping("")
	public List<Product> viewAll(){
		return service.viewAllProducts();
	}
	@GetMapping("{id}")
	public Product viewProductById(@PathVariable long id) {
		return service.viewById(id);
	}
	@PostMapping("/search")
	public Product viewProductByName(@RequestBody String name) {
		return service.getByProductName(name);
	}
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return service.deleteProduct(id);
	}
	@GetMapping("/prod/{productId}")
	public ProductInCart prodbyprodId(@PathVariable long productId) {
		return service.getProdByProdId(productId);
	}
	

}
