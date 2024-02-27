package com.deloitte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.entity.Product;
import com.deloitte.entity.ProductInCart;
import com.deloitte.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository repo;
	
	ProductInCart prod=null;

	@Override
	public Product addProduct(Product product) {
		return repo.save(product);
		
	}

	@Override
	public List<Product> viewAllProducts() {
		return repo.findAll();
	}

	@Override
	public boolean deleteProduct(long id) {
		try {
			repo.deleteById(id);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public Product viewById(long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public boolean getByName(String productName) {
		
		Product prod =repo.findByProductName(productName);
		if(prod==null) {
			return false;
		}
		return true;
	}

	@Override
	public Product getByProductName(String prouductName) {
		return repo.findByProductName(prouductName);
	}

	@Override
	public ProductInCart getProdByProdId(long productId) {
		Product product=repo.findById(productId).orElse(null);
		
		prod.setProductName(product.getProductName());
		prod.setImageUrl(product.getImageUrl());
		prod.setPrice(product.getPrice());
		return prod;
	}
	

}
