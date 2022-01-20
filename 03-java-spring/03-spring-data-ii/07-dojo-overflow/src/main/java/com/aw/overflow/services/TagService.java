package com.aw.overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aw.overflow.models.Tag;
import com.aw.overflow.repositories.TagRepo;

@Service
public class TagService {
	
	@Autowired
	private TagRepo tRepo;
	
	//Get one by subject
	public Tag getTagSubject(String subject) {
		return this.tRepo.findBySubject(subject);
	}
		
	public ArrayList<Tag> splitTags(String tags) {
		ArrayList<Tag> usableTags = new ArrayList<Tag>();
		String[] processTags = tags.split(", ");
		for (String tagsplit: processTags) {
			if(this.tRepo.existsBySubject(tagsplit)) {
				Tag goodTag = this.getTagSubject(tagsplit);
				usableTags.add(goodTag);
			}
			else {
				Tag newTag = new Tag();
				newTag.setSubject(tagsplit);
				this.tRepo.save(newTag);
				usableTags.add(this.getTagSubject(tagsplit));
			}
		}
		return usableTags;
	}
	
	//Create
	public Tag createTag(Tag tag) {
		return this.tRepo.save(tag);
	}
	
	//Get one
	public Tag getOneTag(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	
	//Get all
	public List<Tag> getAllTags(){
		return this.tRepo.findAll();
	}
	
	
}
