package com.cybage.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.MainDao;
import com.cybage.daos.MainDaoImpl;
import com.cybage.model.Book;
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



	@Override
	public List<Book> getBooksFromXmlFile() {
		return dao.getBooksFromXmlFile();
	}




	@Override
	public List<Book> getBooksFromTextFile() {
		return dao.getBooksFromTextFile();
	}




	@Override
	public void addBookToXmlFile(Book book) {
		dao.addBookToXmlFile(book);
		
	}




	@Override
	public void addBookToTextFile(Book book) {
		dao.addBookToTextFile(book);
		
	}

	public void removeBook(int id) {
		dao. removeBook(id);
		
	}


	public void updateBook(Book book,int id) {
		dao. updateBook(book,id);
	}




	
}
