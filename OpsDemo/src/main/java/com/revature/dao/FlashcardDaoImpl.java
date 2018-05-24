package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Flashcard;
import com.revature.util.HibernateUtil;

public class FlashcardDaoImpl implements FlashcardDao {

	public List<Flashcard> getFlashcards() {
		List<Flashcard> flashcards = new ArrayList<Flashcard>();
		Session s = HibernateUtil.getSession();
		flashcards = s.createQuery("from Flashcard").list();
		s.close();
		return flashcards;
	}

	public Flashcard getFlashcardById(int id) {
		Session s = HibernateUtil.getSession();
		//what if this was load????
		Flashcard f = (Flashcard) s.get(Flashcard.class, id); //f is persistent
		//System.out.println(f.getCategory());
		s.close();
		return f;
	}

	public int addFlashcard(Flashcard f) {
		Session s = HibernateUtil.getSession();
		//Transaction tx = s.beginTransaction(); //spooky
		int result = (Integer) s.save(f);
		//tx.commit();
		s.close();
		return result;
	}
	
	public Flashcard persistFlashcard(Flashcard f) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.persist(f);
		f.setAnswer("42");
		tx.commit(); //if we leave this out, nothing will be persisted
		s.close();
		return f;
	}
	
	public void updateFlashcard(Flashcard f) {
		// TODO Auto-generated method stub
		
	}

	public void deleteFlashcard(Flashcard f) {
		// TODO Auto-generated method stub
		
	}

}
