package com.cybage.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import org.apache.commons.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.model.Product;

import com.cybage.model.User;
import com.cybage.services.MainService;
import com.cybage.services.MainServiceImpl;



@Controller
public class MainController {
	
	
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
	
	
	@RequestMapping("/addstudents")
	public String addStudents( Model model,HttpSession session, @RequestParam CommonsMultipartFile[] fileUpload) 
	{
		if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){
                  
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                 
                Product uploadFile = new Product();
                uploadFile.setFilename(aFile.getOriginalFilename());
                uploadFile.setData(aFile.getBytes());
                service.save(uploadFile);               
            }
        }
		/*service.add();
		System.out.println("added in database");*/
		return "alloptions";
		
		
	}
	
	
	@RequestMapping("/allbooks")
	public String showStudents( Model model,HttpSession session,HttpServletResponse response) 
	{
	    Product p = service.showStudents();
	    System.out.println("-------------from dao came back----------------");
		System.out.println(p);
		byte[] b = p.getData();
		byte[] encodeBase64 = Base64.encodeBase64(b);
        String base64Encoded;
		try {
			base64Encoded = new String(encodeBase64, "UTF-8");
			 model.addAttribute("userImage", base64Encoded );
			 return "allbooks";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "alloptions";
        /*String name = "userAvatar";
        response.setContentType("image/jpeg");
        response.setContentLength(thumb.length);
 
        response.setHeader("Content-Disposition", "inline; filename=\"" + name
                + "\"");
 
        BufferedInputStream input = null;
        BufferedOutputStream output = null;
 
        try {
            input = new BufferedInputStream(new ByteArrayInputStream(thumb));
            output = new BufferedOutputStream(response.getOutputStream());
            byte[] buffer = new byte[8192];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } catch (IOException e) {
            System.out.println("There are errors in reading/writing image stream "
                    + e.getMessage());
        } finally {
            if (output != null)
                try {
                    output.close();
                } catch (IOException ignore) {
                }
            if (input != null)
                try {
                    input.close();
                } catch (IOException ignore) {
                }
        }*/
 
		
		
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