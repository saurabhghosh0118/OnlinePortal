package com.cybage.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookXML {
	private int book_id;
	private String name;
	private String author;
	
	public int getBook_id() {
		return book_id;
	}



	
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}



	public String getName() {
		return name;
	}



	
	public void setName(String name) {
		this.name = name;
	}



	public String getAuthor() {
		return author;
	}



	
	public void setAuthor(String author) {
		this.author = author;
	}



	
	@Override
	public String toString() {
		return String.format("BookXML [book_id=%s, name=%s, author=%s]", book_id, name, author);
	}

	
}
