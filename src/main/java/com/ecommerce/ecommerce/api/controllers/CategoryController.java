package com.ecommerce.ecommerce.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.bussiness.abstracts.CategoryService;
import com.ecommerce.ecommerce.core.utilities.results.DataResult;
import com.ecommerce.ecommerce.core.utilities.results.Result;
import com.ecommerce.ecommerce.entities.concrete.Category;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {
	private CategoryService categoryservice;

	@Autowired
	public CategoryController(CategoryService categoryservice) {
		super();
		this.categoryservice = categoryservice;
	}

	@GetMapping("/getall")
	public DataResult<List<Category>> getall() {
		return this.categoryservice.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestParam Category category) {
		return this.categoryservice.add(category);
	}

	@DeleteMapping("/deleteByName/{categoryName}")
	public Result delete(@RequestParam String categoryName) {
		return this.categoryservice.delete(categoryName);
	}

}
