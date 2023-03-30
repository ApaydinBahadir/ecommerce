package com.ecommerce.ecommerce.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entities.concrete.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	Product getById(int productId);

//	List<Product> getByProductId(List<Integer> products);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
}
