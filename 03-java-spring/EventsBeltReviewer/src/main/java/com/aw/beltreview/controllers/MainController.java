package com.aw.beltreview.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aw.beltreview.models.Event;
import com.aw.beltreview.models.Message;
import com.aw.beltreview.models.User;
import com.aw.beltreview.services.EventService;
import com.aw.beltreview.services.MessageService;
import com.aw.beltreview.services.UserService;
import com.aw.beltreview.validators.UserValidator;

@Controller
public class MainController {

	@Autowired
	private UserService uService;

	@Autowired
	private EventService eService;

	@Autowired
	private MessageService mService;

	@Autowired
	private UserValidator userValidator;

	// Login page
	@GetMapping("/")
	public String index(@Valid @ModelAttribute("user") User user) {
		return "index.jsp";
	}

	// Save User
	@PostMapping("/registeruser")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("userId", newUser.getId());
		session.setAttribute("userFirstName", newUser.getFirstName());
		return "redirect:/dashboard";
	}

	// Login
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("email") String email,
			@RequestParam("password") String password, RedirectAttributes redir) {
		if (!uService.authenticateUser(email, password)) {
			redir.addFlashAttribute("loginError", "Invalid login information");
			return "redirect:/";
		}
		User currentUser = this.uService.getOneUserEmail(email);
		session.setAttribute("userId", currentUser.getId());
		session.setAttribute("userFirstName", currentUser.getFirstName());
		return "redirect:/dashboard";
	}

	// Show Dashboard
	@GetMapping("/dashboard")
	public String dashboard(@ModelAttribute("event") Event event, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			User currentUser = uService.getOneUserId((Long) session.getAttribute("userId"));
			model.addAttribute("user", currentUser);
			model.addAttribute("inArea", eService.getEventsInArea(currentUser.getState()));
			model.addAttribute("outOfArea", eService.getEventsNotInArea(currentUser.getState()));
			model.addAttribute("events", eService.getAllEvents());
			return "dashboard.jsp";
		} else {
			return "redirect:/";
		}

	}

	// Save Event
	@PostMapping("/process/event")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model,
			RedirectAttributes redir, HttpSession session) {
		User currentUser = uService.getOneUserId((Long) session.getAttribute("userId"));
		if (result.hasErrors()) {
			model.addAttribute("inArea", eService.getEventsInArea(currentUser.getState()));
			model.addAttribute("outOfArea", eService.getEventsNotInArea(currentUser.getState()));
			model.addAttribute("events", eService.getAllEvents());
			return "dashboard.jsp";
		}
		this.eService.createEvent(event);
		return "redirect:/dashboard";
	}

	// Show Event
	@GetMapping("/event/{id}")
	public String showEvent(@Valid @ModelAttribute("message") Message message, @PathVariable("id") Long id, Model model,
			HttpSession session) {
		if (session.getAttribute("userId") != null) {
			model.addAttribute("event", eService.getOneEvent(id));
			model.addAttribute("messages", this.mService.getAllEventMessages(id));
			return "show.jsp";
		} else {
			return "redirect:/";
		}

	}

	// Save message
	@PostMapping("/process/message")
	public String createMessage(@Valid @ModelAttribute("message") Message message, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/event/" + message.getEvent().getId();
		} else {
			this.mService.createMessage(message);
			return "redirect:/event/" + message.getEvent().getId();
		}
	}

	// Like/Attend Event
	@GetMapping("/process/like/{id}")
	public String createLike(HttpSession session, @PathVariable("id") Long id) {
		User currentUser = uService.getOneUserId((Long) session.getAttribute("userId"));
		Event event = eService.getOneEvent(id);
		this.eService.likeEvent(currentUser, event);
		return "redirect:/dashboard";

	}

	// Unlike Event
	@GetMapping("/process/unlike/{id}")
	public String unlike(HttpSession session, @PathVariable("id") Long id) {
		User currentUser = uService.getOneUserId((Long) session.getAttribute("userId"));
		Event event = eService.getOneEvent(id);
		this.eService.unlikeEvent(currentUser, event);
		return "redirect:/dashboard";
	}
	
	//Show Edit Event Page
	@GetMapping("/edit/{id}")
	public String editEvent(@ModelAttribute("event") Event event, @PathVariable("id") Long id, HttpSession session, Model model) {
		if (session.getAttribute("userId") != null) {
			model.addAttribute("event", eService.getOneEvent(id));
			return "edit.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	
	//Update Event
	@PutMapping("/update/event/{id}")
	public String update(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			eService.updateEvent(event);
			return "redirect:/dashboard";
		}
	}
	
	
	//Delete
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		this.eService.destroyEvent(id);
		return "redirect:/dashboard";
	}

	// Logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
