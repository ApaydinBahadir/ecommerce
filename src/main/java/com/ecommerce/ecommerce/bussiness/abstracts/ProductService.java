package com.ecommerce.ecommerce.bussiness.abstracts;

import java.util.List;

import com.ecommerce.ecommerce.core.utilities.results.DataResult;
import com.ecommerce.ecommerce.entities.concrete.Product;

public interface ProductService {
	
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	DataResult<List<Product>> getByProductNameContains(String productName);
	DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories);
}
