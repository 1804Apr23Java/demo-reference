package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Category;
import com.revature.beans.Flashcard;

@Repository
public interface FlashcardDao extends JpaRepository<Flashcard,Integer> {

}
