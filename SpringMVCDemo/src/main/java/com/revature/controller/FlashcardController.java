package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.revature.beans.Category;
import com.revature.beans.Flashcard;
import com.revature.service.FlashcardService;

@Controller("flashcardController")
@RequestMapping("/flashcard")
public class FlashcardController {

	@Autowired
	private FlashcardService flashcardService;

	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<List<Flashcard>> getAllFlashcards() {
		return new ResponseEntity<>(flashcardService.getFlashcards(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Flashcard> getFlashcardById(@PathVariable int id) {
		ResponseEntity<Flashcard> resp = null;
		for (Flashcard t : flashcardService.getFlashcards()) {
			if (id == t.getId()) {
				resp = new ResponseEntity<>(t, HttpStatus.OK);
			}
		}
		return resp;
	}

	@PostMapping("/addFlashcard")
	@ResponseBody
	public ResponseEntity<String> addFlashcard(@RequestBody Flashcard flashcard) {

		ResponseEntity<String> resp = null;
		try {
			flashcardService.addFlashcard(flashcard);
			resp = new ResponseEntity<>("FLASHCARD CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE FLASHCARD", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@RequestMapping(value="/addWithForm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public String handleFormRequest(@RequestBody MultiValueMap<String, String> formParams) {
		System.out.println("form params received " + formParams);
		Flashcard f = new Flashcard(formParams.getFirst("question"),formParams.getFirst("answer"), new Category(0,formParams.getFirst("category")));
		flashcardService.addFlashcard(f);
		return "forward:/flashcard/all";
		
	}

	// for rendering our simple Flashcard view via the View Resolver
	// String returned from method is name of desired view
	@RequestMapping(value = "/viewWithJSP", method = RequestMethod.GET)
	public String getFlashcardView(Model m) {
		m.addAttribute("flashcards", flashcardService.getFlashcards());
		return "flashcards";

	}

	// for delivering our static HTML pages
	@GetMapping(value = "/staticFlashcard")
	public String getStaticFlashcardPage() {
		return "forward:/static/staticFlashcard.html";
	}

	// to return bundled Angular app
	@GetMapping(value="/app")
	public String getApp() {
		return "forward:/static/index.html";
	}
}
