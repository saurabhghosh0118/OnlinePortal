package com.cybage.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cybage.daos.MainDao;
import com.cybage.daos.MainDaoImpl;
import com.cybage.model.Order;
import com.cybage.model.Product;
import com.cybage.model.User;


@Service
@Transactional
public class MainServiceImpl implements MainService
{

	//MainDao dao = new MainDaoImpl();
	@Autowired
	MainDao dao;
	
	
	public List<User> getUser() 
	{
		System.out.println(dao instanceof MainDaoImpl);
		return dao.getUser();
	}



	public void registerUser(User user) {
		dao.registerUser(user);
		
	}



	@Override
	public List<Product> getProductsForMen() {
		
		return dao.getProductsForMen();
	}



	@Override
	public List<Product> getProductsForWomenen() {
		
		return dao.getProductsForWomen();
	}




	public Product getProduct(int id) {
		return dao.getProduct(id);
	}




	public void saveOrder(Order order) {
		dao.saveOrder(order);
		
	}



	
	public List<Order> getAllOrders(int id) {
		return dao.getAllOrders(id);
	  }






	
}
