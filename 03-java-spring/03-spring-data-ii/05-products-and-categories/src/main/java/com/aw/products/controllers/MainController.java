package com.aw.products.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aw.products.models.Category;
import com.aw.products.models.Product;
import com.aw.products.services.CategoryService;
import com.aw.products.services.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "product.jsp";
	}
	
	@PostMapping("/processproduct")
	public String addProduct(@ModelAttribute("product") Product product) {
		this.productService.createProduct(product);
		
		return "redirect:/";
	}
	
	@GetMapping("/category")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}
	
	@PostMapping("/processcategory")
	public String addCategory(@ModelAttribute("category") Category category) {
		this.categoryService.createCategory(category);
		return "redirect:/";
	}
	
	@GetMapping("/product/{id}")
	public String showProduct(Model model, @PathVariable("id") Long id, Product product) {
		model.addAttribute("product", productService.getOneProduct(id));
		model.addAttribute("category", categoryService.findMissingCategory(product));
		return "showproduct.jsp";
	}
	
	@PostMapping("/product/{id}/addcategory")
	public String addProductToCategory(@PathVariable("id") Long id, @RequestParam("category") Long catId) {
		categoryService.addCategory(productService.getOneProduct(id), categoryService.getOneCategory(catId));
		return "redirect:/product/{id}";
	}
	
	@GetMapping("/category/{id}")
	public String showCategory(@PathVariable("id") Long id, Category category, Model model) {
		model.addAttribute("category", categoryService.getOneCategory(id));
		model.addAttribute("product", productService.findMissingCategory(category));
		return "showcategory.jsp";
	}
	
	@PostMapping("/category/{id}/addproduct")
	public String addCategoryToProduct(@PathVariable("id") Long id, @RequestParam("product") Long prodId) {
		productService.addCategory(categoryService.getOneCategory(id), productService.getOneProduct(prodId));
		return "redirect:/category/{id}";
	}
}
