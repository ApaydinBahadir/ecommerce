package com.ecommerce.ecommerce.bussiness.abstracts;

import java.util.List;

import com.ecommerce.ecommerce.core.utilities.results.DataResult;
import com.ecommerce.ecommerce.core.utilities.results.Result;
import com.ecommerce.ecommerce.entities.concrete.Category;

public interface CategoryService {
	DataResult<List<Category>> getAll();

	Result add(Category category);

	Result delete(String categoryName);
}
