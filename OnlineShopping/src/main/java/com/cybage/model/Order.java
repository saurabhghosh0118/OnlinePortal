package com.cybage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="orderdetails")
public class Order implements Serializable
{
	private int order_id;
	private int product_id;
	private int user_id;
	
	@Id
	@Column(name="orderid")
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	@Column(name="userid")
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	@Column(name="productid")
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	
	
	@Override
	public String toString() {
		return String.format("Order [order_id=%s, product_id=%s, user_id=%s]", order_id, product_id, user_id);
	}
	
	
	
	
	

}
