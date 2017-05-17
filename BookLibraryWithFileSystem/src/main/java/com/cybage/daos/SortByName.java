package com.cybage.daos;

import java.util.Comparator;

import com.cybage.model.Book;



/**
 *Sort elements based on <b>Book Name.
 */
public class SortByName implements Comparator
{
	
	public int compare(Object obj1, Object obj2) {
		Book b1=(Book)obj1;  
		Book b2=(Book)obj2;  
		return b1.getName().compareTo(b2.getName());  
	}

}
