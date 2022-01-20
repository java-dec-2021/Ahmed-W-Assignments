package com.aw.overflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aw.overflow.models.Answer;
import com.aw.overflow.models.Question;
import com.aw.overflow.services.AnswerService;
import com.aw.overflow.services.QuestionService;
import com.aw.overflow.services.TagService;

@Controller
public class MainController {
	
	@Autowired 
	private QuestionService qService;
	
	@Autowired
	private AnswerService aService;
	
	@Autowired
	private TagService tService;
	
	
	@GetMapping("/")
	public String dashboard(Model model) {
		model.addAttribute("questions", qService.getAllQuestions());
		return "dashboard.jsp";
	}
	
	@GetMapping("/questions")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "question.jsp";
	}
	
	@PostMapping("/processquestion")
	public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("failed " + result);
			return "question.jsp";
		}
		this.qService.createQuestion(question);
		System.out.println("Saved");
		return "redirect:/";
	}
	
	@GetMapping("/question/{id}")
	public String showQuestion(Model model, @ModelAttribute("answer") Answer answer, @PathVariable("id") Long id) {
		model.addAttribute("question", qService.getOneQuestion(id));
		return "answer.jsp";
	}
	
	@PostMapping("/processanswer")
	public String createAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question", qService.getOneQuestion(answer.getQuestion().getId()));
			return "answer.jsp";
		}
		this.aService.createAnswer(answer);
		return "redirect:/question/" + answer.getQuestion().getId();
	}
}
