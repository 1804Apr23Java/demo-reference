package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Flashcard;
import com.revature.repository.FlashcardRepository;

@Service(value="flashcardService")
public class FlashcardService {
	
	@Autowired
	FlashcardRepository fr;

	public List<Flashcard> getFlashcards() {
		List<Flashcard> flashcards = fr.getFlashcards();
				/*new ArrayList<Flashcard>();
		Flashcard f = new Flashcard(3,"Where do you stand if you're cold?", "In the corner, it's 90 degrees.",
				new Category(2, "meteorology"));
		Flashcard f2 = new Flashcard(75,"How much wood could a woodchuck chuck?", "Can a woodchuck chuck wood?",
				new Category(2, "meteorology"));
		flashcards.add(f);
		flashcards.add(f2);*/
		return flashcards;
	}

	public void addFlashcard(Flashcard flashcard) {
		
		fr.persistFlashcard(flashcard);
		
	}

}
