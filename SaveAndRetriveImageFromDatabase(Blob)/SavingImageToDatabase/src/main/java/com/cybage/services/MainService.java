package com.cybage.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

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
public interface MainService 
{
	List<User> getUser();
	void add();
	Product showStudents();
	void save(Product uploadFile);
}
