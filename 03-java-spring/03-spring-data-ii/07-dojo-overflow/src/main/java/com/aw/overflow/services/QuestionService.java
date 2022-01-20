package com.aw.overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aw.overflow.models.Question;
import com.aw.overflow.models.Tag;
import com.aw.overflow.repositories.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepo qRepo;
	
	@Autowired
	private TagService tService;
	
	//Create
	public Question createQuestion(Question question) {
		ArrayList<Tag> cleanTags = this.tService.splitTags(question.getTemptags());
		question.setTags(cleanTags);
		return this.qRepo.save(question);
	}
	
	//Get one
	public Question getOneQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	//Get all
	public List<Question> getAllQuestions(){
		return this.qRepo.findAll();
	}
	
	
}
