package com.cybage.daos;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.CoreMatchers.*;

import com.cybage.model.*;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:**/webapp/WEB-INF/dispatcher-servlet.xml")
public class TestMainDaoImpl {
	
	@Autowired
	SessionFactory sf;
	
	@Autowired
	MainDao dao;

	
	
	@Test
	@Transactional
	@Rollback(true)
	public void getUserTest() {
	
		
		@SuppressWarnings( "unchecked")
		List<User> allExpectedUsers = sf.getCurrentSession().createQuery("from User")
				.list();
		List<User> allActualUsersFromDao = dao.getUser();
		System.out.println("---------dao users------"+allActualUsersFromDao);
		System.out.println("---------junit users------"+allExpectedUsers);
		  assertThat(allActualUsersFromDao, is(allActualUsersFromDao));
		
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void registerTest() {
	
		User user = new User();
		user.setUser_name("test");
		user.setUser_password("test");
		dao.registerUser(user); 
		List<User> allActualUsersFromDao = dao.getUser();
		int length = allActualUsersFromDao.size();
		System.out.println(length);
		System.out.println("------------"+allActualUsersFromDao.get((length-1)));
		System.out.println("---------register user---------"+allActualUsersFromDao);
		assertEquals(user.getUser_name(), allActualUsersFromDao.get(length-1).getUser_name());
		assertEquals(user.getUser_password(), allActualUsersFromDao.get(length-1).getUser_password());
		
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void getProductsForMenTest() {
	
		String hql="from Product where product_catagory=?";
        List<Product> allExpectedMenProducts = sf.getCurrentSession().createQuery(hql).setParameter(0, "his").list();
        List<Product> allActualMenProductsFromDao = dao.getProductsForMen();
        assertThat(allActualMenProductsFromDao, is(allExpectedMenProducts));
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void getProductsForWomenTest() {
	
		String hql="from Product where product_catagory=?";
        List<Product> allExpectedWomenProducts = sf.getCurrentSession().createQuery(hql).setParameter(0, "her").list();
        List<Product> allActualWomenenProductsFromDao = dao.getProductsForWomen();
        assertThat(allActualWomenenProductsFromDao, is(allExpectedWomenProducts));
	}
	
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void getProductTest() {
	
		String hql="from Product where product_id=?";
        Product expectedProduct = (Product) sf.getCurrentSession().createQuery(hql).setParameter(0, 3).uniqueResult();
        Product actualProduct = dao.getProduct(3);
        assertEquals(expectedProduct, actualProduct);
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void getAllOrdersTest() {
	
		String hql="from Order where user_id=?";
        List<Order> allExpectedOrders = sf.getCurrentSession().createQuery(hql).setParameter(0,1).list();
        List<Order> allActualOrders = dao.getAllOrders(1);
        assertThat(allActualOrders, is(allExpectedOrders));
	}

}
