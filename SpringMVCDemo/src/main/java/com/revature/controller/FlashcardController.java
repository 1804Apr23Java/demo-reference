package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Category;
import com.revature.beans.Flashcard;

@Controller("flashcardController")
@RequestMapping("/flashcard")
public class FlashcardController {
	
	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<List<Flashcard>> getAllFlashcards(){
		List<Flashcard> flashcards = new ArrayList<Flashcard>();
		Flashcard f = new Flashcard("Where do you stand if you're cold?","In the corner, it's 90 degrees.",new Category(2,"meteorology"));
		flashcards.add(f);
		return new ResponseEntity<>(flashcards, HttpStatus.OK);
	}

}
