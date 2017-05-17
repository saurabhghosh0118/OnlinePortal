package com.cybage.daos;

import java.util.Comparator;

import com.cybage.model.Book;



/**
 *Sort elements based on <b>ID.
 */
public class SortById implements Comparator
{
	 
	public int compare(Object obj1, Object obj2) {
		Book b1=(Book)obj1;  
		Book b2=(Book)obj2;  
		if(b1.getBook_id()==b2.getBook_id())  
		return 0;  
		else if(b1.getBook_id()>b2.getBook_id())  
		return 1;  
		else  
		return -1;  
	}

}
