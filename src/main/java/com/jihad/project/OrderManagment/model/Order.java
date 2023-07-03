package com.jihad.project.OrderManagment.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Represents an order in the order management system.
 */
@Entity
@Table(name = "Orders")
public class Order {

	/**
	 * The unique identifier for the order.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * The date and time when the order was placed.
	 */
	@Column
	private LocalDateTime orderedAt;

	/**
	 * The list of product orders associated with the order.
	 */
	@OneToMany
	private List<ProductOrder> productOrder;

	/**
	 * The customer who placed the order.
	 */
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	/**
	 * Returns the unique identifier for the order.
	 *
	 * @return The order's unique identifier.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique identifier for the order.
	 *
	 * @param id The order's unique identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the date and time when the order was placed.
	 *
	 * @return The order's placed date and time.
	 */
	public LocalDateTime getOrderedAt() {
		return orderedAt;
	}

	/**
	 * Sets the date and time when the order was placed.
	 *
	 * @param orderedAt The order's placed date and time.
	 */
	public void setOrderedAt(LocalDateTime orderedAt) {
		this.orderedAt = orderedAt;
	}

	/**
	 * Returns the list of product orders associated with the order.
	 *
	 * @return The list of product orders.
	 */
	public List<ProductOrder> getProductOrder() {
		return productOrder;
	}

	/**
	 * Sets the list of product orders associated with the order.
	 *
	 * @param productOrder The list of product orders.
	 */
	public void setProductOrder(List<ProductOrder> productOrder) {
		this.productOrder = productOrder;
	}

	/**
	 * Returns the customer who placed the order.
	 *
	 * @return The customer who placed the order.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer who placed the order.
	 *
	 * @param customer The customer who placed the order.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
