package com.deloitte.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Table
@Entity
public class CartItem {
	@Id
	@TableGenerator(name="cartid_gen",table="tbl_cart_id",pkColumnName="cid",valueColumnName="cid_col_val",pkColumnValue="cid_val",allocationSize=1)
	@GeneratedValue(generator="cartid_gen", strategy=GenerationType.TABLE)
	private long cartItemId;
	private String customerId;
	private long productId;
	private int quantity;
	
	CartItem(){}
	public long getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartItem(long cartItemId, String customerId, long productId, int quantity) {
		super();
		this.cartItemId = cartItemId;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}
	public CartItem(String customerId, long productId, int quantity) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}
	

}
