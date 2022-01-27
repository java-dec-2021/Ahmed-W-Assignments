package com.aw.beltreview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aw.beltreview.models.Event;
import com.aw.beltreview.models.User;
import com.aw.beltreview.repositories.EventRepo;

@Service
public class EventService {
	
	@Autowired
	private EventRepo eRepo;
	
	//Create
	public Event createEvent(Event event) {
		return this.eRepo.save(event);
	}
	
	//Get One
	public Event getOneEvent(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
	//Get All in Area
	public List<Event> getEventsInArea(String state) {
		return this.eRepo.findByState(state);
	}
	
	//Get All not in Area
	public List<Event> getEventsNotInArea(String state){
		return this.eRepo.findByStateIsNot(state);
	}
	
	//Get all
	public List<Event> getAllEvents(){
		return this.eRepo.findAll();
	}
	
	//Update
	public Event updateEvent(Event event) {
		return this.eRepo.save(event);
		
	}
	
	//Delete
	public void destroyEvent(Long id) {
		this.eRepo.deleteById(id);
	}
	
	//Like/Attend
	public void likeEvent(User user, Event event) {
		List<User> attendingUsers = event.getAttendees();
		attendingUsers.add(user);
		this.eRepo.save(event);
		
	}
	
	//Unlike
	public void unlikeEvent(User user, Event event) {
		List<User> attendingUsers = event.getAttendees();
		attendingUsers.remove(user);
		this.eRepo.save(event);
		
	}
}
