package com.cybage.daos;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cybage.model.Order;
import com.cybage.model.Product;
import com.cybage.model.User;





@Repository
public class MainDaoImpl implements MainDao
{
	@Autowired
	SessionFactory sf;
	
	
	
	

	
	/**
	 *For getting all users.
	 */
	public List<User> getUser() {
		System.out.println("autowired worked");
		System.out.println(sf);
		
		@SuppressWarnings("unchecked")
		List<User> allUsers = sf.getCurrentSession().createQuery("from User")
				.list();

		System.out.println("in dao");
		System.out.println(allUsers);
		return allUsers;
		
	}




	public List<Product> getProductsForMen() {
		String hql="from Product where product_catagory=?";
         List<Product> allMenProducts = sf.getCurrentSession().createQuery(hql).setParameter(0, "his").list();
		return allMenProducts;
	}




	public List<Product> getProductsForWomen() {
		
		String hql="from Product where product_catagory=?";
        List<Product> allWomenProducts = sf.getCurrentSession().createQuery(hql).setParameter(0, "her").list();
		return allWomenProducts;
	}



	
	public Product getProduct(int id) {
		
		String hql="from Product where product_id=?";
        Product product = (Product) sf.getCurrentSession().createQuery(hql).setParameter(0, id).uniqueResult();
		return product;
	}



	



	public List<Order> getAllOrders(int id) {
		
		String hql="from Order where user_id=?";
        List<Order> allOrders = sf.getCurrentSession().createQuery(hql).setParameter(0,id).list();
		return allOrders;
	}


	
	public void registerUser(User user) 
	{
		
		sf.getCurrentSession().save(user);
	}

	
	
	public void saveOrder(Order order) {
		
		sf.getCurrentSession().save(order);
		
	}


	
	
	

}
