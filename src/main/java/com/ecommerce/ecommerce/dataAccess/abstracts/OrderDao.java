package com.ecommerce.ecommerce.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entities.concrete.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{
	
}
