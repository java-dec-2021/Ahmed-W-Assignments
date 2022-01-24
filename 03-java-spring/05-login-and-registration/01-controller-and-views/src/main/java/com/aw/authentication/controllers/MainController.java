package com.aw.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aw.authentication.models.User;
import com.aw.authentication.services.UserService;

//imports removed for brevity
@Controller
public class MainController {
 private final UserService userService;
 
 public MainController(UserService userService) {
     this.userService = userService;
 }
 
 @RequestMapping("/registration")
 public String registerForm(@ModelAttribute("user") User user) {
     return "registrationPage.jsp";
 }
 @RequestMapping("/login")
 public String login() {
     return "loginPage.jsp";
 }
 
 @RequestMapping(value="/registration", method=RequestMethod.POST)
 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
     if(result.hasErrors()) {
    	 return "registrationPage.jsp";
     }
     
     User newUser = this.userService.registerUser(user);
     session.setAttribute("user_id", newUser.getId());
     return "redirect:/home";
	 
	 // if result has errors, return the registration page (don't worry about validations just now)
     // else, save the user in the database, save the user id in session, and redirect them to the /home route
 }
 
 @RequestMapping(value="/login", method=RequestMethod.POST)
 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redir) {
     // if the user is authenticated, save their user id in session
     // else, add error messages and return the login page
	 if(!userService.authenticateUser(email, password)) {
		 redir.addFlashAttribute("error", "Invalid login details");
		 return "redirect:/login";
	 }
	 session.setAttribute("user_id", userService.findByEmail(email).getId());
	 return "redirect:/home";
 }
 
 @RequestMapping("/home")
 public String home(HttpSession session, Model model) {
     // get user from session, save them in the model and return the home page
	 Long user__id = (Long) session.getAttribute("user_id");
	 User user = userService.findUserById(user__id);
	 model.addAttribute("user", user);
	 return "homePage.jsp";
 }
 @RequestMapping("/logout")
 public String logout(HttpSession session) {
     // invalidate session
     // redirect to login page
	 session.invalidate();
	 return "redirect:/login";
 }
}
