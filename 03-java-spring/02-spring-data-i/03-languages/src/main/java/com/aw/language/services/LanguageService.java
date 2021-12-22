package com.aw.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aw.language.models.Language;
import com.aw.language.repositories.LanguageRepository;

@Service
public class LanguageService{
	
	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public List<Language> allLanguages(){
		return languageRepo.findAll();
	}
	
	public Language createLanguage(Language l) {
		return languageRepo.save(l);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		else {
			return null;
		}
	}
	
	public void destroy(Long id) {
		languageRepo.deleteById(id);
	}
	
	public Language updateLanguage(Language l) {
		return languageRepo.save(l);
	}
	
}
