package com.aw.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aw.dojosandninjas.models.Dojo;
import com.aw.dojosandninjas.models.Ninja;
import com.aw.dojosandninjas.repositories.DojoRepo;
import com.aw.dojosandninjas.repositories.NinjaRepo;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepo dojoRepo;
	@Autowired
	private NinjaRepo ninjaRepo;
	
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	
	public Dojo getDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
	
	public List<Dojo> getAllDojos(){
		return this.dojoRepo.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	
	public Ninja getNinja(Long id) {
		return this.ninjaRepo.findById(id).orElse(null);
	}
	
	public List<Ninja> getAllNinjas(){
		return this.ninjaRepo.findAll();
	}
}
