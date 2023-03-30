package com.ecommerce.ecommerce.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entities.concrete.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{
	
	Category findByCategoryName(String categoryName);
}
