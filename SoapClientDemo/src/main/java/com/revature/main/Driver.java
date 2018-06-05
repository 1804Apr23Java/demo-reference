package com.revature.main;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.model.Book;
import com.revature.service.Library;

public class Driver {

	public static void main(String[] args) {

		Library lib = getLibrary();

		// retrieve books
		List<Book> books = lib.getAllBooks();
		for (Book b : books) {
			System.out.println(b);
		}
		
		//add a book to the library
		//Book newBook = new Book("1984","George Orwell",1949);
		Book newBook = new Book("Dune","Frank Herbert",1965);
		try {
			System.out.println(lib.addBook(newBook));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static Library getLibrary() {
		String serviceURL = "http://localhost:8083/SoapServiceDemo/Library";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Library.class);
		factory.setAddress(serviceURL);

		// set up interceptors
		LoggingInInterceptor inInt = new LoggingInInterceptor();
		LoggingOutInterceptor outInt = new LoggingOutInterceptor();
		factory.getInInterceptors().add(inInt);
		factory.getOutInterceptors().add(outInt);
		inInt.setPrintWriter(new PrintWriter(System.out));
		outInt.setPrintWriter(new PrintWriter(System.out));

		return (Library) factory.create();
	}

}
