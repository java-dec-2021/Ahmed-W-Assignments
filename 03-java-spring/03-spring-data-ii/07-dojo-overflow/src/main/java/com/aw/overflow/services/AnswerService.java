package com.aw.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aw.overflow.models.Answer;
import com.aw.overflow.repositories.AnswerRepo;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepo aRepo;
	
	//Create
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	
	//Get one
	public Answer getOneAnswer(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	
	//Get all
	public List<Answer> getAllAnswer(){
		return this.aRepo.findAll();
	}
	
}
