package com.aw.beltreview.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aw.beltreview.models.User;
import com.aw.beltreview.repositories.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo uRepo;
	
	//Create
	public User registerUser(User user) {
		String hashedpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedpw);
		return uRepo.save(user);
	}
	
	//Get one user by email
	public User getOneUserEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
	//Get one user by id
	public User getOneUserId(Long id) {
		Optional<User> u = uRepo.findById(id);
		
		if(u.isPresent()) {
			return u.get();
		}
		else {
			return null;
		}
	}
	
	//Get All
	public List<User> getAllUsers(){
		return this.uRepo.findAll();
	}
	
	//Update
	
	
	//Delete
	
	//Authenticate
	public boolean authenticateUser(String email, String password) {
		User user = uRepo.findByEmail(email);
		if(user == null) {
			return false;
		}
		else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
}
