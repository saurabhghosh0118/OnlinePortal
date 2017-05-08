package com.cybage.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cybage.model.Order;
import com.cybage.model.Product;
import com.cybage.model.User;
import com.cybage.services.MainService;
import org.apache.log4j.Logger;




@Controller
public class MainController {
	
	private static final Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
	MainService service;

	static int id;
	static String  user_name = "Hi Guest";
	

	/**
	 * 
	 * @return
	 * login page
	 */
	@RequestMapping("/login")
	public String loginPage() 
	{
		
		return "login";
	}
	
	

	/**
	 * 
	 * @param model
	 * @param session
	 * @return
	 * homepage
	 */
	@RequestMapping("/homepage")
	public String homePage(ModelMap model,HttpSession session) 
	{
		
		if(logger.isDebugEnabled()){
			logger.debug("---------------homePage is executed!-----------------");
		}
		
		String user_session = (String)session.getAttribute("user_session");
			
		//shows different button on the basis of session  
		if(user_session != null)
		{
			model.addAttribute("visibility", "true");
		}
		else
		{
			model.addAttribute("visibility", null);
		}
		
		model.addAttribute("username", user_name);
		return "homepage";
	}
	
	
	
	/**
	 * 
	 * @param input_user
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 * <b>homepage</b>(<i>if credentials are correct</i>)</br>
	 * <b>login</b>(<i>if credentials are incorrect</i>)
	 * 
	 */
	@RequestMapping("/afterlogin")
	public String afterLogin(@ModelAttribute("SpringWeb") User input_user,HttpServletRequest request,ModelMap model,HttpSession session)
	{
		
		if(logger.isDebugEnabled()){
			logger.debug("-------------------afterLogin is executed!------------------");
		   }
		
		
		   String name = input_user.getUser_name();
		   String pass = input_user.getUser_password();
		   List<User> allUsers = service.getUser();
		   
		   for (User user : allUsers) 
		   {
			   
			  if(user.getUser_password().equals(pass) && user.getUser_name().equals(name))
			  {
				 
				 request.getSession().setAttribute("user_session", user.getUser_name());
				 user_name = "Hi "+ user.getUser_name();
				 model.addAttribute("visibility", "true");
				 model.addAttribute("username", user_name);
				 return "homepage";
			  }
			
		    }
		

		  
		   return "redirect:/login";
		
	}
		
	
	/**
	 * 
	 * @param session
	 * @return
	 * registration page
	 */
	@RequestMapping(value = "/signup")
	public String signUp() 
	{

		if(logger.isDebugEnabled()){
			logger.debug("---------------signUp is executed!-----------------");
		}
		
		return "registration";
	}
	
	
	
	/**
	 * 
	 * @param user
	 * @param session
	 * @return
	 * successfulregistration page
	 */
	@RequestMapping(value = "/registeruser")
	public String registerUser(@ModelAttribute("Spring") User user,HttpSession session) 
	{
		if(logger.isDebugEnabled()){
			logger.debug("---------------signUp is executed!-----------------");
		}
		
		
		session.invalidate();
		String name = user.getUser_name();
		String password = user.getUser_password();
		User user_to_register = new User();
		user_to_register.setUser_name(name);
		user_to_register.setUser_password(password);
		service.registerUser(user_to_register);
		return "successfulregistration";
	}
	
	
	/**
	 * 
	 * @param model
	 * @param session
	 * @return
	 * displayproducts page(<i>for women products</i>)
	 */
	@RequestMapping(value = "/his")
	public String hisItems(ModelMap model,HttpSession session) 
	{
		if(logger.isDebugEnabled()){
			logger.debug("---------------hisItems is executed!-----------------");
		}
		
		
		String user_session = (String)session.getAttribute("user_session");
		if(user_session != null)
		{
			model.addAttribute("visibility", "true");
		}
		
		List<Product> allProducts=service.getProductsForMen();
		model.addAttribute("allProducts",allProducts);
		return "displayproducts";
	}
	
	
	/**
	 * 
	 * @param model
	 * @param session
	 * @return
	 * displayproducts(<i>for women products</i>)
	 */
	@RequestMapping(value = "/her")
	public String herItems(ModelMap model,HttpSession session) 
	{
		if(logger.isDebugEnabled()){
			logger.debug("-------------------herItems is executed!------------------");
		   }
		
		
		String user_session = (String)session.getAttribute("user_session");
		if(user_session != null)
		{
			model.addAttribute("visibility", "true");
		}
		List<Product> allProducts=service.getProductsForWomenen();
		model.addAttribute("allProducts",allProducts);
		return "displayproducts";
	}
	
	
	
	/**
	 * 
	 * @param product_id
	 * @param model
	 * @param session
	 * @return
	 * checkout page
	 */
	@RequestMapping(value = "/buy")
	public String buyProducts(@RequestParam("yourButton") int product_id,ModelMap model,HttpSession session) 
	{
		if(logger.isDebugEnabled()){
			logger.debug("-------------------buyProducts is executed!------------------");
		   }
		
		
		String user_session = (String)session.getAttribute("user_session");
		if(user_session != null)
		{
			model.addAttribute("visibility", "true");
		}
		System.out.println("in buy mapping");
		System.out.println(product_id);
		id=product_id;
		Product product = service.getProduct(product_id);
		
		model.addAttribute("product", product);
		return "checkout";
	}
	
	
	/**
	 * 
	 * @param product_id
	 * @param model
	 * @param session
	 * @return
	 * thankyou page(<i>if user logged in</i>)</br>
	 * homepage page(<i>if user do not loged in</i>) 
	 */
	@RequestMapping(value = "/checkout")
	public String checkout(@RequestParam("yourButton") int product_id,ModelMap model,HttpSession session) 
	{
		
		if(logger.isDebugEnabled()){
			logger.debug("-------------------checkout is executed!------------------");
		   }
		
		String user_session = (String)session.getAttribute("user_session");
		if(user_session != null)
		{
			model.addAttribute("visibility", "true");
			List<User> allUsers = service.getUser();
			logger.info(allUsers);
			   for (User user : allUsers) 
			   {
			      logger.info(user.getUser_name());
			      logger.info("----------------------------------------"+user_session);
				  if(user.getUser_name().equals(user_session) )
				  {
					Order order = new Order();
					order.setProduct_id(product_id);
					order.setUser_id(user.getUser_id());
					service.saveOrder(order);
				  }
				
			    }
			 
			   return "thankyou";
		}
		else
		{
			model.addAttribute("message", "Please Login First to continue Shopping");
			return "homepage";
		}
		
		
		
	}
	
	
	/**
	 * 
	 * @param session
	 * @param model
	 * @return
	 * orderhistory page
	 */
	@RequestMapping(value = "/orderhistory")
	public String orderHistory(HttpSession session,ModelMap model) 
	{
		if(logger.isDebugEnabled()){
			logger.debug("-------------------orderHistory is executed!------------------");
		   }
		
		String user_session = (String)session.getAttribute("user_session");
		if(user_session != null)
		{
			List<User> allUsers = service.getUser();
			List<Order> all_orders;
			
			List<Product> all_products = new ArrayList<Product>();
			   for (User user : allUsers) 
			   {
				  
				 if(user.getUser_name().equals(user_session) )
				  {
					  all_orders = service.getAllOrders(user.getUser_id());
					  System.out.println(all_orders);
					  for (Order order : all_orders) 
					   {
						  Product product = service.getProduct(order.getProduct_id());
						  all_products.add(product);
					    }
					  
				  }
				
			    }
			   model.addAttribute("allProducts", all_products);
			   return "orderhistory";
			   
		}
		else
		{
			model.addAttribute("message", "Please Login First");
			return "homepage";
		}
	}
	
	
	/**
	 * 
	 * @param model
	 * @param session
	 * @return
	 * homepage
	 */
	@RequestMapping(value = "/logout")
	public String logout(ModelMap model,HttpSession session) 
	{
		if(logger.isDebugEnabled()){
			logger.debug("-------------------orderHistory is executed!------------------");
		   }
		
		session.invalidate();
		user_name = "Hi Guest";
		model.addAttribute("username", user_name);
		return "homepage";
	}

}