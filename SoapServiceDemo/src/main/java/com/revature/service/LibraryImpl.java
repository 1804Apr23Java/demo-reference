package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.exception.PropagandaException;
import com.revature.model.Book;

@WebService(endpointInterface="com.revature.service.Library")
public class LibraryImpl implements Library {

	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("Gravity's Rainbow","Thomas Pynchon",1973));
		bookList.add(new Book("Farenheit 451","Ray Bradbury",1953));
		bookList.add(new Book("Brave New World","Aldous Huxley",1932));
		return bookList;
	}

	@Override
	public String addBook(Book book) throws PropagandaException {
		//not really doing anything in particular
		if (book.getTitle().equals("1984")) {
			throw new PropagandaException();
		}
		return "successfully added "+book.getTitle();
	}

}
