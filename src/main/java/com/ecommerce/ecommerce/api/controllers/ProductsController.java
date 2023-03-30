package com.ecommerce.ecommerce.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.bussiness.abstracts.ProductService;
import com.ecommerce.ecommerce.core.utilities.results.DataResult;
import com.ecommerce.ecommerce.entities.concrete.Product;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@GetMapping("/getbycategory")
	public DataResult<List<Product>> getByCategoryIn(@RequestParam("categories") List<Integer> categories){
		return this.productService.getByCategory_CategoryIdIn(categories);
	}
}
