package com.aw.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/date")
	public String date(Model dateModel) {
		Date date = new Date();

		String pattern = "EEEE, d MMMM, yyyy";
		SimpleDateFormat currentDate = new SimpleDateFormat(pattern);
		String stringDate = currentDate.format(date);
		dateModel.addAttribute("date", stringDate);
		return "date.jsp";
	}
	
	@GetMapping("/time")
	public String time(Model dateModel) {
		Date date = new Date();
		String pattern = "HH:MM a";
		SimpleDateFormat currentTime = new SimpleDateFormat(pattern);
		String stringTime = currentTime.format(date);
		dateModel.addAttribute("time", stringTime);
		return "time.jsp";
	}
	
}
