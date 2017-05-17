package com.cybage.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "books")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookList {
	
	 @XmlElement(name = "book")
    private List<BookXML> book_list = new ArrayList<BookXML>();

	public List<BookXML> getBook_list() {
		return book_list;
	}

	public void setBook_list(List<BookXML> book_list) {
		this.book_list = book_list;
	}

	@Override
	public String toString() {
		return String.format("BookList [book_list=%s]", book_list);
	}

	
	
}
