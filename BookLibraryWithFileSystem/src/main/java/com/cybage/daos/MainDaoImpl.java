package com.cybage.daos;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Repository;

import com.cybage.model.Book;
import com.cybage.model.BookList;
import com.cybage.model.BookXML;
import com.cybage.model.User;
import com.cybage.model.UserXML;



@Repository
public class MainDaoImpl implements MainDao
{

	@Override
	
	public List<User> getUser() {
		/**
		 * For text file
		 */
		try {
			FileInputStream fis = new FileInputStream("C:/Users/saurabhgh/Desktop/users.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<User> user_list = (List<User>) ois.readObject();
			System.out.println(user_list);
			return user_list;
		
    	} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		
		
		return null;
	}

	
	@Override
	public List<Book> getBooksFromXmlFile() {
		/**
		 * For xml file
		 */
       try {

			JAXBContext jaxbContext2 = JAXBContext.newInstance(BookList.class);
		    Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();
		    BookList bookList = (BookList) jaxbUnmarshaller2.unmarshal( new File("C:/Users/saurabhgh/Desktop/books.xml") );
		    List<Book> list = new ArrayList<Book>();
		    for (BookXML b : bookList.getBook_list()) {
				  Book b1 = new Book();
				  b1.setBook_id(b.getBook_id());
				  b1.setName(b.getName());
				  b1.setAuthor(b.getAuthor());
				  list.add(b1);
			}
		    return list;
		   

		      } catch (JAXBException e) {
			e.printStackTrace();
		      }
		return null;
	}




	@Override
	public List<Book> getBooksFromTextFile() {
		/**
		 * For text file
		 */
		try {
				FileInputStream fis = new FileInputStream("C:/Users/saurabhgh/Desktop/books.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
				List<Book> book_list = (List<Book>) ois.readObject();
				System.out.println(book_list);
				return book_list;
			
	    	} catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
	
		return null;
	}




	@Override
	public void addBookToXmlFile(Book book) {
		/**
		 * For xml file
		 */
		try {

			JAXBContext jaxbContext2 = JAXBContext.newInstance(BookList.class);
		    Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();
		    BookList bookList = (BookList) jaxbUnmarshaller2.unmarshal( new File("C:/Users/saurabhgh/Desktop/books.xml") );
		    BookXML add_book = new BookXML();
		    add_book.setBook_id(book.getBook_id());
		    add_book.setName(book.getName());
		    add_book.setAuthor(book.getAuthor());
		    bookList.getBook_list().add(add_book);
		    
		    
		    File file = new File("C:/Users/saurabhgh/Desktop/books.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(bookList, file);
		    } 
		catch (JAXBException e) {
			e.printStackTrace();
		    }
		
		
	}




	@Override
	public void addBookToTextFile(Book book) {
		/**
		 * For text file
		 */
		try {
			List<Book> books = getBooksFromTextFile();
			books.add(book);
			FileOutputStream fos = new FileOutputStream("C:/Users/saurabhgh/Desktop/books.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(books);
			oos.close();
		
    	} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		} 
		
	}
	
	

	@Override
	public void removeBook(int id) {
		/**
		 * For xml file
		 */
		/*try {
			List<Book> books = getBooks();
			for (Book book : books) {
				if(book.getBook_id()==id)
				{
					books.remove(book);
					break;
				}
				
			}
			FileOutputStream fos = new FileOutputStream("C:/Users/saurabhgh/Desktop/books.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(books);
			oos.close();
		
    	} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		} */
		
	}

	@Override
	public void updateBook(Book book, int id) {
		try {
			List<Book> books = getBooksFromTextFile();
			int i=0;
			for (Book b : books) {
				
				if(b.getBook_id()==id)
				{
					books.set(i, book);
					break;
				}
				i++;
				
			}
			FileOutputStream fos = new FileOutputStream("C:/Users/saurabhgh/Desktop/books.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(books);
			oos.close();
		
    	} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		} 
		
	}




	
}
