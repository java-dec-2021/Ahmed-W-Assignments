package com.aw.beltreview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aw.beltreview.models.Message;
import com.aw.beltreview.repositories.MessageRepo;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepo mRepo;
	
	//Create
	public Message createMessage(Message message) {
		return this.mRepo.save(message);
	}
	
	//Get one
	
	
	//Get all
	public List<Message> getAllMesages(){
		return this.mRepo.findAll();
	}
	
	//Get all for one event
	public List<Message> getAllEventMessages(Long id){
		return this.mRepo.findAllByEventId(id);
	}
}
