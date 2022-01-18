package com.aw.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aw.products.models.Category;
import com.aw.products.models.Product;

import com.aw.products.repositories.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
		
	//Create
	public Product createProduct(Product product) {
		return this.productRepo.save(product);
	}
	
	//Get one
	public Product getOneProduct(Long id) {
		return this.productRepo.findById(id).orElse(null);
	}
	
	//Get all
	public List<Product> getAllProducts(){
		return this.productRepo.findAll();
	}
	
	//Find missing
	public List<Product> findMissingCategory(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
	//Add product to category
		public void addCategory(Category category, Product product) {
			List<Category> categoryList = product.getCategories();
			categoryList.add(category);
			productRepo.save(product);
			
		}
}
