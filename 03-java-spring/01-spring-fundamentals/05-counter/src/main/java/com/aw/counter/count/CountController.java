package com.aw.counter.count;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CountController {
	
	@GetMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			int newCount = currentCount+1;
			session.setAttribute("count", newCount);
			
		}
		return "index.jsp";
	}
	
	@GetMapping("/counter")
	public String counter() {
		
		return "counter.jsp";
	}
}
