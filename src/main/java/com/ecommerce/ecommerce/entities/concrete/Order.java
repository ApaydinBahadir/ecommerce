package com.ecommerce.ecommerce.entities.concrete;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "product_ids")
	private int[] productId;

	@Column(name = "unit_prices")
	private float[] unitPrices;

	@Column(name = "quantities")
	private int[] quantities;

	@Column(name = "discount")
	private int[] discount;
}
