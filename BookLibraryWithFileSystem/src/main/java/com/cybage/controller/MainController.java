package com.cybage.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cybage.daos.SortById;
import com.cybage.daos.SortByName;
import com.cybage.model.Book;
import com.cybage.model.User;
import com.cybage.services.MainService;
import com.cybage.services.MainServiceImpl;



@Controller
public class MainController {
	
	static int update_id;
	@Autowired
	MainService service;


	@RequestMapping("/login")
	public String showMessage1() 
	{
		return "login";
	}

	/**
	 * This is mapped to onclick of Login Button
	 * @param input_user
	 * @param request
	 * @param model
	 * @param session
	 * @return String
	 */
	@RequestMapping("/afterlogin")
	public String afterLogin(@ModelAttribute("SpringWeb") User input_user,HttpServletRequest request,ModelMap model,HttpSession session)
	{
		String user_session = (String)session.getAttribute("user_session");
		if(user_session==null)
		{
		String name = input_user.getUser_name();
		String pass = input_user.getUser_password();
		List<User> allUsers = service.getUser();
		for (User user : allUsers) 
		{
			System.out.println(user.getUser_name());
			System.out.println(user.getUser_password());
			if(user.getUser_password().equals(pass) && user.getUser_name().equals(name))
			{
				 request.getSession().setAttribute("user_session", user.getUser_name());
				 return "alloptions";
			}
			
		 }
		    return "redirect:/login";
		   }
		else
		{
			return "alloptions";
		}
	}
	
	
	/**
	 * For displaying all books
	 * @param model
	 * @param session
	 * @returnString
	 */
	@RequestMapping("/allbooksTXT")
	public String showAllBooks( @PathVariable int id,Model model,HttpSession session) 
	{
		System.out.println("------------------all books------------------");
		System.out.println(id);
		String user_session = (String)session.getAttribute("user_session");
		if(user_session!=null)
		{
			List<Book> allBooks = service.getBooksFromTextFile();
			System.out.println(allBooks);
			model.addAttribute("allBooks", allBooks);
			return "allbooks";
		}
		else
		{
			return "login";
		}
		
	}
	
	
	
	/**
	 * To delete a book
	 * @param id
	 * @param session
	 * @return String
	 */
	@RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable int id,HttpSession session) 
	{
		String user_session = (String)session.getAttribute("user_session");
		if(user_session!=null)
		{
			service.removeBook(id);
			return "redirect:/allbooks";
		}
		else
		{
			return "login";
		}
	}
	
	
	
	/**
	 * To send to update page
	 * @param id
	 * @param model
	 * @param session
	 * @return String
	 */
	@RequestMapping(value = "/edit/{id}")
	public String editBook(@PathVariable int id,ModelMap model,HttpSession session)
	{
		String user_session = (String)session.getAttribute("user_session");
		if(user_session!=null)
		{
			System.out.println("in edit");
			update_id=id;
			model.addAttribute("book_id", id);
			return "update";
		}
		else
		{
				return "login";
		}
	}
	
	
	
	/**
	 * For updating a book
	 * @param book
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateBook")
	public String updateBook(@ModelAttribute("SpringWeb") Book book,HttpSession session) 
	{
		String user_session = (String)session.getAttribute("user_session");
		if(user_session!=null)
		{
			System.out.println("in update");
			service.updateBook(book,update_id);
			return "alloptions";
		}
		else
		{
			return "login";
		}
	}
	
	
	
	
	/**
	 * To send to add book page
	 * @param book
	 * @param session
	 * @return String
	 */
	@RequestMapping(value = "/add")
	public String add(@ModelAttribute("SpringWeb") Book book,HttpSession session) 
	{
		String user_session = (String)session.getAttribute("user_session");
		if(user_session!=null)
		{
			return "addbook";
		}
		else
		{
			return "login";
		}
	}
	
	
	
	/**
	 * To add a book 
	 * @param book
	 * @param session
	 * @return String
	 */
	@RequestMapping(value = "/addBook")
	public String addBook(@ModelAttribute("SpringWeb") Book book,HttpSession session)
	{

		String user_session = (String)session.getAttribute("user_session");
		if(user_session!=null)
		{
	    service.addBookToTextFile(book);
		return "redirect:/allbooks";
		}
		else
		{
			return "login";
		}
	}
	
	
	/**
	 * For sorting records bases on Book ID
	 * @param session
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/sortById")
	public String sortById(HttpSession session,ModelMap model)
	{

		String user_session = (String)session.getAttribute("user_session");
		if(user_session!=null)
		{
			List<Book> allBooks = service.getBooksFromTextFile();
			Collections.sort(allBooks, new SortById());
			model.addAttribute("allBooks", allBooks);
			return "allbooks";
		}
		else
		{
			return "login";
		}
	}
	
	
	
	/**
	 * For sorting records bases on Book Name
	 * @param session
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/sortByName")
	public String sortByName(HttpSession session,ModelMap model)
	{

		String user_session = (String)session.getAttribute("user_session");
		if(user_session!=null)
		{
			List<Book> allBooks = service.getBooksFromTextFile();
			Collections.sort(allBooks, new SortByName());
			model.addAttribute("allBooks", allBooks);
			return "allbooks";
		}
		else
		{
			return "login";
		}
	}
	
	
	/**
	 * 
	 * @param session
	 * @return String
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) 
	{
		session.invalidate();
		return "redirect:/login";
	}

}