package com.ecommerce.ecommerce.bussiness.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.bussiness.abstracts.CategoryService;
import com.ecommerce.ecommerce.core.utilities.results.DataResult;
import com.ecommerce.ecommerce.core.utilities.results.Result;
import com.ecommerce.ecommerce.core.utilities.results.SuccessDataResult;
import com.ecommerce.ecommerce.core.utilities.results.SuccessResult;
import com.ecommerce.ecommerce.dataAccess.abstracts.CategoryDao;
import com.ecommerce.ecommerce.entities.concrete.Category;

@Service
public class CategoryManager implements CategoryService {
	private CategoryDao categoryDao;

	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public DataResult<List<Category>> getAll() {
		return new SuccessDataResult<List<Category>>(this.categoryDao.findAll(), "All Category Listed");
	}

	@Override
	public Result add(Category category) {
		categoryDao.save(category);
		return new SuccessResult("Added Successfully");
	}

	@Override
	public Result delete(String categoryName) {
		this.categoryDao.delete(this.categoryDao.findByCategoryName(categoryName));
		return new SuccessResult("Deleted Successfully");
	}

}
