package com.jihad.project.OrderManagment.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Represents an Order Data Transfer Object (DTO) used for transferring order
 * data.
 */
public class OrderDTO {

	private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime orderedAt;

	private List<ProductOrderDTO> productOrder;

	private CustomerDTO customer;

	/**
	 * Returns the ID of the order.
	 *
	 * @return The ID of the order.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the ID of the order.
	 *
	 * @param id The ID of the order.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the date and time when the order was placed.
	 *
	 * @return The date and time when the order was placed.
	 */
	public LocalDateTime getOrderedAt() {
		return orderedAt;
	}

	/**
	 * Sets the date and time when the order was placed.
	 *
	 * @param orderedAt The date and time when the order was placed.
	 */
	public void setOrderedAt(LocalDateTime orderedAt) {
		this.orderedAt = orderedAt;
	}

	/**
	 * Returns the list of product orders associated with the order.
	 *
	 * @return The list of product orders associated with the order.
	 */
	public List<ProductOrderDTO> getProductOrder() {
		return productOrder;
	}

	/**
	 * Sets the list of product orders associated with the order.
	 *
	 * @param productOrder The list of product orders associated with the order.
	 */
	public void setProductOrder(List<ProductOrderDTO> productOrder) {
		this.productOrder = productOrder;
	}

	/**
	 * Returns the customer associated with the order.
	 *
	 * @return The customer associated with the order.
	 */
	public CustomerDTO getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer associated with the order.
	 *
	 * @param customer The customer associated with the order.
	 */
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
}
