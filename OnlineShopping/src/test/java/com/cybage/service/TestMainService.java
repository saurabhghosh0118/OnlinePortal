package com.cybage.service;



import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.cybage.model.Order;
import com.cybage.model.Product;
import com.cybage.model.User;
import com.cybage.services.MainServiceImpl;




public class TestMainService 
{
	
	@Test
	public void getUserTest() 
	{
		MainServiceImpl service = new MainServiceImpl(){
			@Override
			public List<User> getUser() 
			{
				List<User> allUsers = new ArrayList<User>();
				User user_one = new User();
				     user_one.setUser_id(1);
				     user_one.setUser_name("saurabh");
				     user_one.setUser_password("ghosh");
				User user_two = new User();
					 user_two.setUser_id(2);
					 user_two.setUser_name("bob");
					 user_two.setUser_password("123");
				User user_three = new User();
					 user_three.setUser_id(3);
					 user_three.setUser_name("sam");
					 user_three.setUser_password("test");
				allUsers.add(user_one);
				allUsers.add(user_two);
				allUsers.add(user_three);
				return allUsers;

			}
			
		};
		
		List<User> expected_test_Users = new ArrayList<User>();
		User test_user_one = new User();
				test_user_one.setUser_id(1);
				test_user_one.setUser_name("saurabh");
				test_user_one.setUser_password("ghosh");
	    User test_user_two = new User();
	    		test_user_two.setUser_id(2);
	    		test_user_two.setUser_name("bob");
	    		test_user_two.setUser_password("123");
	    User test_user_three = new User();
	    		test_user_three.setUser_id(3);
	    		test_user_three.setUser_name("sam");
	    		test_user_three.setUser_password("test");
	    	expected_test_Users.add(test_user_one);
	    	expected_test_Users.add(test_user_two);
	    	expected_test_Users.add(test_user_three);
		
		
	    	List<User> actual_test_Users = service.getUser();
	    	//assertThat(actual_test_Users, is(expected_test_Users));
	    	for (int i = 0; i < actual_test_Users.size()-1; i++) {
	    		assertEquals(expected_test_Users.get(i).getUser_id(), actual_test_Users.get(i).getUser_id());
	    		assertEquals(expected_test_Users.get(i).getUser_name(), actual_test_Users.get(i).getUser_name());
	    		assertEquals(expected_test_Users.get(i).getUser_password(), actual_test_Users.get(i).getUser_password());
	    		
				
			}
		
	 }
	
	
	
	
	
	@Test
	public void registerTest() {
	
		MainServiceImpl service = new MainServiceImpl(){
			@Override
			public void registerUser(User user) {
				User test_user_one = new User();
				test_user_one.setUser_id(1);
				test_user_one.setUser_name("saurabh");
				test_user_one.setUser_password("ghosh");
				assertEquals(test_user_one.getUser_id(), user.getUser_id());
				assertEquals(test_user_one.getUser_name(),user.getUser_name());
				assertEquals(test_user_one.getUser_password(),user.getUser_password());
				
			}

			
		};
		
		
		User user = new User();
		user.setUser_id(1);
		user.setUser_name("saurabh");
		user.setUser_password("ghosh");
		service.registerUser(user);
		
		
	}
	
	
	
	@Test
	public void getProductsForMenTest() 
	{
		MainServiceImpl service = new MainServiceImpl(){
			@Override
			public List<Product> getProductsForMen() 
			{
				List<Product> allProducts = new ArrayList<Product>();
				Product product_one = new Product();
					product_one.setProduct_id(1);;
					product_one.setProduct_name("product1");
					product_one.setProduct_img("img1");
					product_one.setProduct_description("Rs 1000");
					product_one.setProduct_catagory("his");
				Product product_two = new Product();
					product_two.setProduct_id(2);;
					product_two.setProduct_name("product2");
					product_two.setProduct_img("img2");
					product_two.setProduct_description("Rs 1000");
					product_two.setProduct_catagory("his");
			    Product product_three = new Product();
			    	product_three.setProduct_id(3);;
			    	product_three.setProduct_name("product3");
			    	product_three.setProduct_img("img3");
			    	product_three.setProduct_description("Rs 1000");
			    	product_three.setProduct_catagory("his");
			    allProducts.add(product_one);
			    allProducts.add(product_two);
			    allProducts.add(product_three);
				return allProducts;

			}
			
		};
		
		List<Product> expected_test_Product = new ArrayList<Product>();
		Product product_one = new Product();
				product_one.setProduct_id(1);;
				product_one.setProduct_name("product1");
				product_one.setProduct_img("img1");
				product_one.setProduct_description("Rs 1000");
				product_one.setProduct_catagory("his");
		Product product_two = new Product();
				product_two.setProduct_id(2);;
				product_two.setProduct_name("product2");
				product_two.setProduct_img("img2");
				product_two.setProduct_description("Rs 1000");
				product_two.setProduct_catagory("his");
		Product product_three = new Product();
    			product_three.setProduct_id(3);;
    			product_three.setProduct_name("product3");
    			product_three.setProduct_img("img3");
    			product_three.setProduct_description("Rs 1000");
    			product_three.setProduct_catagory("his");
       expected_test_Product.add(product_one);
       expected_test_Product.add(product_two);
       expected_test_Product.add(product_three);
		
		
	    	List<Product> actual_test_Product = service.getProductsForMen();
	    	
	    	for (int i = 0; i < actual_test_Product.size()-1; i++) {
	    		assertEquals(expected_test_Product.get(i).getProduct_name(),actual_test_Product.get(i).getProduct_name());
	    		assertEquals(expected_test_Product.get(i).getProduct_img(), actual_test_Product.get(i).getProduct_img());
	    		assertEquals(expected_test_Product.get(i).getProduct_description(), actual_test_Product.get(i).getProduct_description());
	    		assertEquals(expected_test_Product.get(i).getProduct_catagory(), actual_test_Product.get(i).getProduct_catagory());
				
			}
		
	 }

	
	
	
	@Test
	public void getProductsForWomenenTest() 
	{
		MainServiceImpl service = new MainServiceImpl(){
			@Override
			public List<Product> getProductsForWomenen() 
			{
				List<Product> allProducts = new ArrayList<Product>();
				Product product_one = new Product();
					product_one.setProduct_id(1);;
					product_one.setProduct_name("product1");
					product_one.setProduct_img("img1");
					product_one.setProduct_description("Rs 1000");
					product_one.setProduct_catagory("her");
				Product product_two = new Product();
					product_two.setProduct_id(2);;
					product_two.setProduct_name("product2");
					product_two.setProduct_img("img2");
					product_two.setProduct_description("Rs 1000");
					product_two.setProduct_catagory("her");
			    Product product_three = new Product();
			    	product_three.setProduct_id(3);;
			    	product_three.setProduct_name("product3");
			    	product_three.setProduct_img("img3");
			    	product_three.setProduct_description("Rs 1000");
			    	product_three.setProduct_catagory("her");
			    allProducts.add(product_one);
			    allProducts.add(product_two);
			    allProducts.add(product_three);
				return allProducts;

			}
			
		};
		
		List<Product> expected_test_Product = new ArrayList<Product>();
		Product product_one = new Product();
				product_one.setProduct_id(1);;
				product_one.setProduct_name("product1");
				product_one.setProduct_img("img1");
				product_one.setProduct_description("Rs 1000");
				product_one.setProduct_catagory("her");
		Product product_two = new Product();
				product_two.setProduct_id(2);;
				product_two.setProduct_name("product2");
				product_two.setProduct_img("img2");
				product_two.setProduct_description("Rs 1000");
				product_two.setProduct_catagory("her");
		Product product_three = new Product();
    			product_three.setProduct_id(3);;
    			product_three.setProduct_name("product3");
    			product_three.setProduct_img("img3");
    			product_three.setProduct_description("Rs 1000");
    			product_three.setProduct_catagory("her");
       expected_test_Product.add(product_one);
       expected_test_Product.add(product_two);
       expected_test_Product.add(product_three);
		
		
	    	List<Product> actual_test_Product = service.getProductsForWomenen();
	    	
	    	for (int i = 0; i < actual_test_Product.size()-1; i++) {
	    		assertEquals(expected_test_Product.get(i).getProduct_name(),actual_test_Product.get(i).getProduct_name());
	    		assertEquals(expected_test_Product.get(i).getProduct_img(), actual_test_Product.get(i).getProduct_img());
	    		assertEquals(expected_test_Product.get(i).getProduct_description(), actual_test_Product.get(i).getProduct_description());
	    		assertEquals(expected_test_Product.get(i).getProduct_catagory(), actual_test_Product.get(i).getProduct_catagory());
				
			}
		
	 }
	
	
	@Test
	public void getProductTest() 
	{
		MainServiceImpl service = new MainServiceImpl(){
			@Override
			public Product getProduct(int id)
			{
				List<Product> allProducts = new ArrayList<Product>();
			    Product actual_product = new Product();
			    
				Product product_one = new Product();
					product_one.setProduct_id(1);;
					product_one.setProduct_name("product1");
					product_one.setProduct_img("img1");
					product_one.setProduct_description("Rs 1000");
					product_one.setProduct_catagory("her");
				Product product_two = new Product();
					product_two.setProduct_id(2);;
					product_two.setProduct_name("product2");
					product_two.setProduct_img("img2");
					product_two.setProduct_description("Rs 1000");
					product_two.setProduct_catagory("her");
			    Product product_three = new Product();
			    	product_three.setProduct_id(3);;
			    	product_three.setProduct_name("product3");
			    	product_three.setProduct_img("img3");
			    	product_three.setProduct_description("Rs 1000");
			    	product_three.setProduct_catagory("her");
			    allProducts.add(product_one);
			    allProducts.add(product_two);
			    allProducts.add(product_three);
			    
			    for (Product product : allProducts) {
			    	if(product.getProduct_id()==id)
			    	{
			    		actual_product = product;
			    	}
			    	
				}
				return actual_product;
			}
			
		};
		
		Product expected_product = new Product();
			expected_product.setProduct_id(1);;
			expected_product.setProduct_name("product1");
			expected_product.setProduct_img("img1");
			expected_product.setProduct_description("Rs 1000");
			expected_product.setProduct_catagory("her");
		
		Product actual_product = service.getProduct(1);
		
		assertEquals(expected_product.getProduct_id(),actual_product.getProduct_id());
		assertEquals(expected_product.getProduct_name(),actual_product.getProduct_name());
		assertEquals(expected_product.getProduct_img(),actual_product.getProduct_img());
		assertEquals(expected_product.getProduct_description(),actual_product.getProduct_description());
		assertEquals(expected_product.getProduct_catagory(),actual_product.getProduct_catagory());
	 }

	
	@Test
	public void saveOrderTest() {
	
		MainServiceImpl service = new MainServiceImpl(){
			@Override
			public void saveOrder(Order order) {
				Order test_order = new Order();
					test_order.setOrder_id(1);
					test_order.setProduct_id(1);
					test_order.setUser_id(1);
				assertEquals(test_order.getOrder_id(), order.getUser_id());
				assertEquals(test_order.getProduct_id(),order.getProduct_id());
				assertEquals(test_order.getUser_id(),order.getUser_id());
				
			}

			
		};
		
		
		Order order = new Order();
		order.setOrder_id(1);
		order.setProduct_id(1);
		order.setUser_id(1);
		service.saveOrder(order);
		
		
	}
	
	
	
	@Test
	public void getAllOrdersTest() 
	{
		MainServiceImpl service = new MainServiceImpl(){
			@Override
			public List<Order> getAllOrders(int id)
			{
				List<Order> allOrders = new ArrayList<Order>();
				List<Order> actual_orders = new ArrayList<Order>();
			    
			    Order order_one = new Order();
			    	order_one.setOrder_id(1);
			    	order_one.setProduct_id(1);
			    	order_one.setUser_id(1);
			    Order order_two = new Order();
			    	order_two.setOrder_id(2);
			    	order_two.setProduct_id(2);
			    	order_two.setUser_id(1);
			    Order order_three = new Order();
			    	order_three.setOrder_id(3);
			    	order_three.setProduct_id(3);
			    	order_three.setUser_id(2);
			    allOrders.add(order_one);
			    allOrders.add(order_two);
			    allOrders.add(order_three);
			    
			    for (Order order : allOrders) {
			    	if(order.getUser_id()==id)
			    	{
			    		actual_orders.add(order);
			    	}
			    	
				}
				return actual_orders;
			}
			
		};
		List<Order> expected_orders = new ArrayList<Order>();
		 Order order_one = new Order();
	    	order_one.setOrder_id(1);
	    	order_one.setProduct_id(1);
	    	order_one.setUser_id(1);
	    Order order_two = new Order();
	    	order_two.setOrder_id(2);
	    	order_two.setProduct_id(2);
	    	order_two.setUser_id(1);
	    expected_orders.add(order_one);
	    expected_orders.add(order_two);
	    
	    List<Order> actual_orders = service.getAllOrders(1);
	    
	    for (int i = 0; i < expected_orders.size()-1; i++) {
	    	assertEquals(expected_orders.get(i).getOrder_id(),actual_orders.get(i).getOrder_id());
	    	assertEquals(expected_orders.get(i).getProduct_id(),actual_orders.get(i).getProduct_id());
	    	assertEquals(expected_orders.get(i).getUser_id(),actual_orders.get(i).getUser_id());
		}
	 }
}
