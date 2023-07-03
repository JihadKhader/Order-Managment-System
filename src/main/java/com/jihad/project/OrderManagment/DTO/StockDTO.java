package com.jihad.project.OrderManagment.DTO;

import java.time.LocalDateTime;

/**
 * A Data Transfer Object (DTO) representing a Stock.
 */
public class StockDTO {

	private Long id;
	private Integer quantity;
	private LocalDateTime updatedAt;
	private Integer productId;

	/**
	 * Get the ID of the stock.
	 *
	 * @return the ID of the stock
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the ID of the stock.
	 *
	 * @param id the ID to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the quantity of the stock.
	 *
	 * @return the quantity of the stock
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Set the quantity of the stock.
	 *
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get the timestamp when the stock was last updated.
	 *
	 * @return the updatedAt timestamp
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Set the timestamp when the stock was last updated.
	 *
	 * @param updatedAt the updatedAt timestamp to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * Get the ID of the associated product.
	 *
	 * @return the product ID
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * Set the ID of the associated product.
	 *
	 * @param productId the product ID to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
}
