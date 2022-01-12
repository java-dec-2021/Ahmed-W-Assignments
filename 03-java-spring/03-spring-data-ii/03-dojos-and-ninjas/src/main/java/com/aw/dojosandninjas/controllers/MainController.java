package com.aw.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aw.dojosandninjas.models.Dojo;
import com.aw.dojosandninjas.models.Ninja;
import com.aw.dojosandninjas.services.DojoService;

@Controller
public class MainController {

	@Autowired
	private DojoService dService;
	
	@RequestMapping("/")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
	
	@RequestMapping(value="/processdojo", method=RequestMethod.POST)
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojo.jsp";
		}
		this.dService.createDojo(dojo);
		return "redirect:/";
	}
	
	@RequestMapping("/ninja")
	public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dService.getAllDojos());
		return "ninja.jsp";
	}
	
	@RequestMapping(value="/processninja", method=RequestMethod.POST)
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "ninja.jsp";
		}
		this.dService.createNinja(ninja);
		return "redirect:/";
	}
	
	@RequestMapping("/dojos/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		model.addAttribute("dojos", dService.getDojo(id));
		return "show.jsp";
	}
}
