package com.ecommerce.ecommerce.bussiness.abstracts;

import com.ecommerce.ecommerce.core.utilities.results.Result;
import com.ecommerce.ecommerce.entities.concrete.Order;

public interface OrderService {

	Result add(Order order);
}
