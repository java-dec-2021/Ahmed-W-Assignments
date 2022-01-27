package com.aw.beltreview.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.aw.beltreview.models.User;
import com.aw.beltreview.repositories.UserRepo;

@Component
public class UserValidator {
	
	@Autowired
	private UserRepo uRepo;
	
	public boolean supports (Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			errors.rejectValue("passwordConfirmation", "wrongPass", "Passwords do not match");
		}
		
		if(this.uRepo.existsByEmail(user.getEmail())){
			errors.rejectValue("email", "unique", "Email address already registered");
		}
	}
}
