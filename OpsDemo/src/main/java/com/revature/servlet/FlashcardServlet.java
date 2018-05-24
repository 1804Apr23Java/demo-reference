package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Category;
import com.revature.beans.Flashcard;

public class FlashcardServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setAccessControlHeaders(resp);
		List<Flashcard> cardList = new ArrayList<Flashcard>();
		cardList.add(new Flashcard(3,"What is Java","The best language",new Category(2,"coding")));
		cardList.add(new Flashcard(7,"What is the answer to life, the universe, and everything?","42",new Category(2,"meteorology")));
		resp.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		String cardString = om.writeValueAsString(cardList);
		resp.getWriter().write("{\"flashcards\":"+cardString+"}");
	}
	
	private void setAccessControlHeaders(HttpServletResponse resp) {
	      resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
	      resp.setHeader("Access-Control-Allow-Methods", "GET");
	  }

}
