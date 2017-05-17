package com.cybage.entry;

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

import com.cybage.model.BookList;
import com.cybage.model.BookXML;
import com.cybage.model.UserXML;



public class MainDemo 
{
	public static void main(String[] args) {
		
		
		/*try {
			List<Book> input_book_list = new ArrayList<Book>();
			List<User> input_user_list = new ArrayList<User>();
			
			Book book1 = new Book();
			book1.setBook_id(1);
			book1.setName("book1");
			book1.setAuthor("Saurabh");
			input_book_list.add(book1);
			
			Book book2 = new Book();
			book2.setBook_id(2);
			book2.setName("book2");
			book2.setAuthor("Saurabh Ghosh");
			input_book_list.add(book2);
			
			Book book3 = new Book();
			book3.setBook_id(3);
			book3.setName("book3");
			book3.setAuthor("Saurabh G");
			input_book_list.add(book3);
			
			Book book4 = new Book();
			book4.setBook_id(4);
			book4.setName("book4");
			book4.setAuthor("Bunty");
			input_book_list.add(book4);
			
			Book book5 = new Book();
			book5.setBook_id(5);
			book5.setName("book5");
			book5.setAuthor("Dada");
			input_book_list.add(book5);
			
			
			
			
			User user = new User();
			user.setUser_id(1);
			user.setUser_name("1");
			user.setUser_password("1");
			input_user_list.add(user);
			// write object to file
			FileOutputStream fos = new FileOutputStream("C:/Users/saurabhgh/Desktop/books.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(input_book_list);
			oos.close();
			
			FileOutputStream fos1 = new FileOutputStream("C:/Users/saurabhgh/Desktop/users.txt");
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
			oos1.writeObject(input_user_list);
			oos1.close();

			// read object from file
			
			FileInputStream fis = new FileInputStream("C:/Users/saurabhgh/Desktop/books.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			//ois.close();
			//System.out.println(result);
			//result = (Book) ois.readObject();
			//System.out.println(result);
			
			List<Book> result = (List<Book>) ois.readObject();
			System.out.println(result);
			
	    
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		
		
		
		try {

			BookList blist = new BookList();
			
			
			
			BookXML book = new BookXML();
			book.setBook_id(1);
			book.setName("Book1");
			book.setAuthor("Saurabh");
			blist.getBook_list().add(book);
			
			
			BookXML book2 = new BookXML();
			book2.setBook_id(2);
			book2.setName("Book2");
			book2.setAuthor("Saurabh G");
			blist.getBook_list().add(book2);

			BookXML book3 = new BookXML();
			book3.setBook_id(3);
			book3.setName("Book3");
			book3.setAuthor("Saurabh Ghosh");
			blist.getBook_list().add(book3);
			
			
			
			
			File file = new File("C:/Users/saurabhgh/Desktop/books.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(BookList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(blist, file);
			//jaxbMarshaller.marshal(book, System.out);
			
			
			
			/*File file2 = new File("C:/Users/saurabhgh/Desktop/books.xml");
			JAXBContext jaxbContext2 = JAXBContext.newInstance(BookXML.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext2.createUnmarshaller();
			BookXML customer = (BookXML) jaxbUnmarshaller.unmarshal(file2);
			System.out.println(customer);*/
			
			
			UserXML user = new UserXML();
			user.setId(1);
			user.setName("Saurabh");
			user.setPassword("1");
			
			File user_file = new File("C:/Users/saurabhgh/Desktop/users.xml");
			JAXBContext user_jaxbContext = JAXBContext.newInstance(UserXML.class);
			Marshaller user_jaxbMarshaller = user_jaxbContext.createMarshaller();

			// output pretty printed
			user_jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			user_jaxbMarshaller.marshal(user, user_file);
			
			
			File user_file2 = new File("C:/Users/saurabhgh/Desktop/users.xml");
			JAXBContext user_jaxbContext2 = JAXBContext.newInstance(UserXML.class);
			Unmarshaller user_jaxbUnMarshaller = user_jaxbContext2.createUnmarshaller();
			UserXML admin = (UserXML) user_jaxbUnMarshaller.unmarshal(user_file2);
			System.out.println("-----------------------");
			System.out.println(admin);
			
			
			
			
			JAXBContext jaxbContext2 = JAXBContext.newInstance(BookList.class);
		    Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();
		     
		    //We had written this file in marshalling example
		    BookList bookList = (BookList) jaxbUnmarshaller2.unmarshal( new File("C:/Users/saurabhgh/Desktop/books.xml") );
		    /*for(BookXML emp : bookList.getBook_list())
		    {
		        System.out.println(emp.getName());
		        System.out.println(emp.getAuthor());
		    }*/
		    System.out.println(bookList);
		   

		      } catch (JAXBException e) {
			e.printStackTrace();
		      }

		}
	
		
	

    
		
		

}
