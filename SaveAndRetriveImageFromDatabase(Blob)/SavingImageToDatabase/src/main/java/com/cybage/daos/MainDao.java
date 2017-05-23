package com.cybage.daos;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.cybage.model.Product;

import com.cybage.model.User;




public interface MainDao 
{
	List<User> getUser();
	void add();
	Product show();
	void save(Product uploadFile);
}
