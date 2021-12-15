package com.aw.routing.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DojoController {
	
	
	@RequestMapping("/dojo")
	public String index() {
		return "The dojo is awesome";
	}
	
	@RequestMapping("/dojo/{city}")
	public String burbank(@PathVariable("city") String city){switch(city) {
		case "burbank":
		return "Burbank Dojo is located in Southern California";
		
		case "san-jose":
			return "San Jose dojo is the headquarters";
		
			default:
				return String.format("%s is pretty sweet", city);
	}
	}
}
