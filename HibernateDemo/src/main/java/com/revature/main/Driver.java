package com.revature.main;

import java.util.List;

import com.revature.beans.Category;
import com.revature.beans.Flashcard;
import com.revature.dao.CategoryDao;
import com.revature.dao.CategoryDaoImpl;
import com.revature.dao.FlashcardDao;
import com.revature.dao.FlashcardDaoImpl;

public class Driver {

	public static void main(String[] args) {
	
		init();
	
	}
	
	public static void init() {
		
	/*	Session s = HibernateUtil.getSession();
		System.out.println(s.isOpen());
		s.close();
		System.out.println(s.isOpen()); */
		
		CategoryDao cd = new CategoryDaoImpl();
		Category c1 = new Category("coding");
		c1.setId(cd.addCategory(c1));
		Category c2 = new Category("meteorology");
		c2.setId(cd.addCategory(c2));
		
		FlashcardDao fd = new FlashcardDaoImpl();
		Flashcard f1 = new Flashcard("What is Java?","The best language",c1);
		Flashcard f2 = new Flashcard("Is it raining?","not right now... maybe",c2);
		
		fd.addFlashcard(f1);
		fd.addFlashcard(f2);
		
		List<Flashcard> fcl = fd.getFlashcards();
		for (Flashcard f : fcl) {
			System.out.println(f);
		}
	}

}
