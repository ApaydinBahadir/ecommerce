package com.ecommerce.ecommerce.bussiness.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.bussiness.abstracts.ProductService;
import com.ecommerce.ecommerce.core.utilities.results.DataResult;
import com.ecommerce.ecommerce.core.utilities.results.SuccessDataResult;
import com.ecommerce.ecommerce.dataAccess.abstracts.ProductDao;
import com.ecommerce.ecommerce.entities.concrete.Product;

@Service
public class ProductManager implements ProductService{
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"All Products Listed");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable = 	PageRequest.of(pageNo, pageSize);

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent(),"Products Listed by Page");		
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Products Listed by Contains");
	}

	@Override
	public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategory_CategoryIdIn(categories), "Products Listed by Category in");
	}
}
