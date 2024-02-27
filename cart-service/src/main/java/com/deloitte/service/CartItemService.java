package com.deloitte.service;

import java.util.List;

import com.deloitte.entity.CartItem;

public interface CartItemService {
	CartItem addCartItem(CartItem cartItem);
	List<CartItem> viewCartByCustomerId(String customerId);
	boolean removeCartItem(long cartItemId);
	//boolean removeCartItemByProdcutId(long productId);
	void deleteAll();
	

}
