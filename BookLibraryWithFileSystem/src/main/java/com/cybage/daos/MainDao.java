package com.cybage.daos;

import java.util.List;

import com.cybage.model.Book;
import com.cybage.model.BookXML;
import com.cybage.model.User;



/**
 * Provides functionality for</br>
 * Getting all users.</br>
 * Getting all Books.</br>
 * Adding a Book</br>
 * Removing a Book.</br>
 * Update an existing entry
 * 
 */
public interface MainDao 
{
	List<User> getUser();
	List<Book> getBooksFromXmlFile();
	List<Book> getBooksFromTextFile();
	void addBookToXmlFile(Book book);
	void addBookToTextFile(Book book);
	void removeBook(int id);
	void updateBook(Book book, int id);
}
