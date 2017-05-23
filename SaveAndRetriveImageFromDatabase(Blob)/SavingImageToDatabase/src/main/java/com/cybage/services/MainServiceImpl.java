package com.cybage.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cybage.daos.MainDao;
import com.cybage.daos.MainDaoImpl;
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


	
	public void add() 
	{
		dao.add();
		
	}



	public Product showStudents() {
		return dao.show();
		
	}



	@Override
	public void save(Product uploadFile) {
		dao.save(uploadFile);
		
	}



	


	
}
