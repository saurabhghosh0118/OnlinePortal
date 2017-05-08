package com.cybage.daos;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.cybage.model.Order;
import com.cybage.model.Product;
import com.cybage.model.User;



/**
 * Provides functionality for</br>
 * Getting all users.</br>
 * Getting all Books.</br>
 * Adding a Book</br>
 * Removing a Book.</br>
 * Update an existing entry
 * 
 */
public interface MainDao 
{
	List<User> getUser();
	List<Product> getProductsForMen();
	List<Product> getProductsForWomen();
	List<Order> getAllOrders(int id);
	Product getProduct(int id);
	void saveOrder(Order order);
	void registerUser(User user);

}
