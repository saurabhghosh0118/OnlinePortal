package com.cybage.daos;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

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
		
		
		@SuppressWarnings("unchecked")
		List<User> allUsers = sf.getCurrentSession().createQuery("from User")
				.list();

		return allUsers;
		
	}



	public void add() {
	
		
		System.out.println("In Add");
		
	}



	public Product show() {
		String hql="from Product where id=?";
        Product product = (Product) sf.getCurrentSession().createQuery(hql).setParameter(0, 1).uniqueResult();
		return product;
	}


	 public void save(Product uploadFile) {
		 sf.getCurrentSession().save(uploadFile);
	    }
	

}
