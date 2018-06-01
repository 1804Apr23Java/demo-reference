package com.revature.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Flashcard;

@Component("flashcardClient")
public class FlashcardClient {

	@Autowired
	private RestTemplate restTemplate;

	private String resourceUrl;

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	// Jackson is doing a lot of work behind the scenes!!
	// .exchange method allows finer-grained control over request being sent
	public List<Flashcard> getFlashcards() {
		ResponseEntity<List<Flashcard>> response = this.restTemplate.exchange(this.resourceUrl + "/flashcard/all",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Flashcard>>() {
				});
		return response.getBody();
	}

}
