package com.revature.media;

import java.io.Serializable;

public class Movie extends Media implements Comparable<Movie>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6871337386839137513L;

	public Movie(String producer, String title, int yearPublished, String genre) {
		super();
		this.producer = producer;
		this.title = title;
		this.yearPublished = yearPublished;
		this.genre = genre;
	}

	public Movie() {
		super();
	}

	private String producer;

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		return "Movie [producer=" + producer + ", title=" + title + ", yearPublished=" + yearPublished + ", genre=" + genre
				+ "]";
	}
	
	public int compareTo(Movie m) {
		return this.yearPublished.compareTo(m.getYearPublished());
	}
}
