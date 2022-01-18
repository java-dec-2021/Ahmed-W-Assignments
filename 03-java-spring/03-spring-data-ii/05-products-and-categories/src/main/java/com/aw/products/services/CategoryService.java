package com.aw.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aw.products.models.Category;
import com.aw.products.models.Product;
import com.aw.products.repositories.CategoryRepo;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	
	
	//Create
	public Category createCategory(Category category) {
		return this.categoryRepo.save(category);
	}
	
	//Get one
	public Category getOneCategory(Long id) {
		return this.categoryRepo.findById(id).orElse(null);
	}
	
	//Get all
	public List<Category> getAllCategory() {
		return this.categoryRepo.findAll();
	}
	
	//Find categories not in list
	public List<Category> findMissingCategory(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
	//Add category to product
	public void addCategory(Product product, Category category) {
		List<Product> productList = category.getProducts();
		productList.add(product);
		categoryRepo.save(category);
	}
	
	
	
}
