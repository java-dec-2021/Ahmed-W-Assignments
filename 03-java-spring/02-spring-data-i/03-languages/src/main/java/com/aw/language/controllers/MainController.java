package com.aw.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aw.language.models.Language;
import com.aw.language.services.LanguageService;

@Controller
public class MainController {
	
	private final LanguageService languageServ;
	
	public MainController (LanguageService languageServ) {
		this.languageServ = languageServ;
	}
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = languageServ.allLanguages();
		System.out.println(languages);
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@RequestMapping("/validate")
	public String validLang(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if  (result.hasErrors()) {
			return "index.jsp";
		}
		else {
			languageServ.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(@RequestParam (value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		Language language = new Language(name, creator, version);
		languageServ.createLanguage(language);
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language lang = languageServ.findLanguage(id);
		model.addAttribute("language", lang);
		return "show.jsp";
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language lang = languageServ.findLanguage(id);
		model.addAttribute("language", lang);
		return "edit.jsp";
		
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update(@RequestParam(value="id") Long id, @RequestParam (value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		
			Language lang = new Language (id, name, creator, version);
			languageServ.updateLanguage(lang);
			return "redirect:/languages";
	}
	

	@RequestMapping("/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		languageServ.destroy(id);
		return "redirect:/languages";
	}
}
