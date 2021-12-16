package com.aw.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(@ModelAttribute("error") String error, Model model) {
		model.addAttribute("error", error);
		
		return "index.jsp";
	}
	
	@GetMapping("/code")
	public String code() {
		
		return "code.jsp";
	}
	
	@RequestMapping(path="/guess", method=RequestMethod.POST)
	public String guess(@RequestParam(value="guess") String guess, RedirectAttributes redirect) {
		
		if(guess.equals("bushido")) {
			return "redirect:/code";
		}
		else {
			redirect.addFlashAttribute("error", "You must train harder");
			return "redirect:/";
		}
		
	}
	
}
