package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.exception.PropagandaException;
import com.revature.model.Book;

@WebService
public interface Library {
	
	/*
	 * a contract (WSDL) will be generated based on this interface
	 * go to /Library?wsdl to see the file 
	 */
	
	public List<Book> getAllBooks();
	
	public String addBook(Book book) throws PropagandaException;

}
