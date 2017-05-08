package com.cybage.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.cybage.model.User;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:**/webapp/WEB-INF/dispatcher-servlet.xml")
public class TestMainController {

	
	
	@Autowired
	MainController controller;
	
	
	@Test
	@Rollback(true)
	public void loginPageTest_Success() {
	
		String actualPage = controller.loginPage();
		String expectedPage = "login";
		assertEquals(expectedPage,actualPage);
		
	}
	
	
	@Test
	@Rollback(true)
	public void loginPageTest_Failure() {
	
		String actualPage = controller.loginPage();
		String expectedPage = "logout";
		boolean flag = actualPage.equals(expectedPage);
		System.out.println(flag);
		assertFalse(flag);
		
	}
	
	
	@Test
	@Rollback(true)
	public void homePageTest(){
		User user = new User();
		ModelMap model = new ModelMap();
		model.addAttribute(user);
		 MockHttpServletRequest request = new MockHttpServletRequest();
		HttpSession session = request.getSession();
	    session.setAttribute("user_session", "saurabh");
		String actualPage = controller.homePage(model, session);
		String expectedPage = "homepage";
		assertEquals(expectedPage,actualPage);
			
     }
	
	


	
	@Test
	@Rollback(true)
	public void afterLoginTest_Failure(){
		User user = new User();
		user.setUser_name("saurabh");
		user.setUser_password("bob");
		ModelMap model = new ModelMap();
		 MockHttpServletRequest request = new MockHttpServletRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user_session", "saurabh");
		String actualPage = controller.afterLogin(user, request, model, session);
		String expectedPage = "redirect:/login";
		assertEquals(expectedPage,actualPage);
			
     }
	
	
	@Test
	@Rollback(true)
	public void signUpTest(){
		
		String actualPage = controller.signUp();
		String expectedPage = "registration";
		assertEquals(expectedPage,actualPage);
		
			
     }
	
	
	
	
	@Test
	@Rollback(true)
	public void registerUserTest(){
		User user = new User();
		MockHttpServletRequest request = new MockHttpServletRequest();
	    HttpSession session = request.getSession();
		String actualPage = controller.registerUser(user, session);
		String expectedPage = "successfulregistration";
		assertEquals(expectedPage,actualPage);
		
			
     }
	
	
	
	@Test
	@Rollback(true)
	public void hisItemsTest(){
		ModelMap model = new ModelMap();
		MockHttpServletRequest request = new MockHttpServletRequest();
		HttpSession session = request.getSession();
		String actualPage = controller.hisItems(model, session);
		String expectedPage = "displayproducts";
		assertEquals(expectedPage,actualPage);
		
			
     }
	
	
	
	@Test
	@Rollback(true)
	public void herItemsTest(){
		ModelMap model = new ModelMap();
		MockHttpServletRequest request = new MockHttpServletRequest();
		HttpSession session = request.getSession();
		String actualPage = controller.hisItems(model, session);
		String expectedPage = "displayproducts";
		assertEquals(expectedPage,actualPage);
	}
	
	
	@Test
	@Rollback(true)
	public void buyProductsTest(){
		ModelMap model = new ModelMap();
		MockHttpServletRequest request = new MockHttpServletRequest();
		HttpSession session = request.getSession();
		String actualPage = controller.buyProducts(1, model, session);
		String expectedPage = "checkout";
		assertEquals(expectedPage,actualPage);
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void checkoutTest_Failure(){
		ModelMap model = new ModelMap();
		MockHttpServletRequest request = new MockHttpServletRequest();
		HttpSession session = request.getSession();
		//session = null(as it is not set for any user)
		String actualPage = controller.checkout(1, model, session);
		String expectedPage = "homepage";
		assertEquals(expectedPage,actualPage);
	}
	
	

	/*@Test
	@Rollback(true)
	public void orderHistoryTest_Success(){
		ModelMap model = new ModelMap();
		MockHttpServletRequest request = new MockHttpServletRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user_session", "saurabh");
		String actualPage = controller.orderHistory(session, model);
		String expectedPage = "orderhistory";
		assertEquals(expectedPage,actualPage);
	}*/
	

	@Test
	@Rollback(true)
	public void orderHistoryTest_Failure(){
		ModelMap model = new ModelMap();
		MockHttpServletRequest request = new MockHttpServletRequest();
		HttpSession session = request.getSession();
		//session = null(as it is not set for any user)
		String actualPage = controller.orderHistory(session, model);
		String expectedPage = "homepage";
		assertEquals(expectedPage,actualPage);
	}
	
	
	@Test
	@Rollback(true)
	public void logoutTest(){
		ModelMap model = new ModelMap();
		MockHttpServletRequest request = new MockHttpServletRequest();
		HttpSession session = request.getSession();
		String actualPage = controller.logout(model, session);
		String expectedPage = "homepage";
		assertEquals(expectedPage,actualPage);
	}
    
}
