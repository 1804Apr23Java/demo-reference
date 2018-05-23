package com.revature.dao;

import java.util.List;

import com.revature.beans.Flashcard;

public interface FlashcardDao {

	public List<Flashcard> getFlashcards();

	public Flashcard getFlashcardById(int id);

	public int addFlashcard(Flashcard f);
	
	public Flashcard persistFlashcard(Flashcard f);

	public void updateFlashcard(Flashcard f);

	public void deleteFlashcard(Flashcard f);

}
