package com.ecommerce.ecommerce.bussiness.concrete;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.bussiness.abstracts.OrderService;
import com.ecommerce.ecommerce.core.utilities.results.Result;
import com.ecommerce.ecommerce.core.utilities.results.SuccessResult;
import com.ecommerce.ecommerce.dataAccess.abstracts.OrderDao;
import com.ecommerce.ecommerce.entities.concrete.Order;

@Service
public class OrderManager implements OrderService {

	private OrderDao orderDao;
	
	public OrderManager(OrderDao orderDao){
		super();
		this.orderDao = orderDao;
	}

	@Override
	public Result add(Order order) {
		this.orderDao.save(order);
		return new SuccessResult("Order saved");
	}
	
}
