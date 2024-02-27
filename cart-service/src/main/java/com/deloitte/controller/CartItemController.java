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

import com.deloitte.entity.CartItem;
import com.deloitte.service.CartItemService;

@RestController
@RequestMapping("/cartitem")
@CrossOrigin
public class CartItemController {
	
	@Autowired
	CartItemService service;
	
	@PostMapping("/add")
	public CartItem addCartItems(@RequestBody CartItem cartItem) {
		return service.addCartItem(cartItem);
	}
	@GetMapping("/items/{customerId}")
	public List<CartItem> viewCartItemsByCustomerId(@PathVariable String customerId){
		return service.viewCartByCustomerId(customerId);
	}
	@DeleteMapping("/delete/{cartItemId}")
	public boolean deleteCartItem(@PathVariable long cartItemId) {
		return service.removeCartItem(cartItemId);
	}
//	@DeleteMapping("/delete/{productId}")
//	public boolean deleteCartItemByProduct(@PathVariable long productId) {
//		return service.removeCartItem(cartItemId);
//	}
	@DeleteMapping("/deleteall")
	public void deleteAllCartItems() {
		service.deleteAll();
	}
	
	
	

}
