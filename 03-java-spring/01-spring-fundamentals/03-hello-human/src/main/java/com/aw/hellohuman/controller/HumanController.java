package com.aw.hellohuman.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class HumanController {
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false, defaultValue = "Human") String name, 
			@RequestParam(value="lastname", required=false, defaultValue = "") String lastName, 
			@RequestParam(value="times", required=false, defaultValue = "1") String times) {
			
			int repeater = Integer.parseInt(times);
			String result = String.format("Hello %s %s ", name, lastName);
						
			return result.repeat(repeater);
		
	}
	
	
}
