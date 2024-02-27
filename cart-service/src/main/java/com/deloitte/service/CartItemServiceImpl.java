package com.deloitte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.entity.CartItem;
import com.deloitte.repository.CartItemRepository;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	CartItemRepository repo;
	
	@Override
	public CartItem addCartItem(CartItem cartItem) {
		return repo.save(cartItem);
	}

	@Override
	public List<CartItem> viewCartByCustomerId(String customerId) {
		return repo.findByCustomerId(customerId);
	}

	@Override
	public boolean removeCartItem(long cartItemId) {
		try{
			repo.deleteById(cartItemId);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
		
	}

}
