package com.revature.main;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.model.Book;
import com.revature.service.Library;

public class Driver {

	public static void main(String[] args) {

		Library lib = getLibrary();
		
		//retrieve books
		List<Book> books = lib.getAllBooks();
		for (Book b : books) {
			System.out.println(b);
		}
		
	}

	public static Library getLibrary() {
		String serviceURL = "http://localhost:8083/SoapServiceDemo/Library";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Library.class);
		factory.setAddress(serviceURL);

		return (Library) factory.create();
	}

}
