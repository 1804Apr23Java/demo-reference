package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Flashcard;

@Repository(value="flashcardRepository")
@Transactional
@EnableTransactionManagement //does same thing as <tx:annotation-driven>
public class FlashcardRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	public List<Flashcard> getFlashcards() {
		List<Flashcard> flashcards = new ArrayList<Flashcard>();
		Session s = sessionFactory.getCurrentSession();
		flashcards = s.createQuery("from Flashcard").list();
		return flashcards;
	}

	public Flashcard persistFlashcard(Flashcard f) {
		Session s = sessionFactory.getCurrentSession();
		s.persist(f);
		return f;
	}


}
