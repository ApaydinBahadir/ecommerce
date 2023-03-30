package com.ecommerce.ecommerce.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.bussiness.abstracts.OrderService;
import com.ecommerce.ecommerce.core.utilities.results.Result;
import com.ecommerce.ecommerce.entities.concrete.Order;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class OrderController {
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam Order order) {
		return this.orderService.add(order);
	}
	
}
