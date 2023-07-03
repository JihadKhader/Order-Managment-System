package com.jihad.project.OrderManagment.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents the stock of a product.
 */
@Entity
@Data
@Table(name = "Stock")
public class Stock {

	/**
	 * The unique identifier of the stock.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * The quantity of the product in stock.
	 */
	@Column
	private int quantity;

	/**
	 * The date and time when the stock was last updated.
	 */
	@Column
	private LocalDateTime updatedAt;

	/**
	 * The product associated with the stock.
	 */
	@ManyToOne
	@JoinColumn
	private Product product;

	/**
	 * Get the unique identifier of the stock.
	 *
	 * @return the stock identifier
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the unique identifier of the stock.
	 *
	 * @param id the stock identifier
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the quantity of the product in stock.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Set the quantity of the product in stock.
	 *
	 * @param quantity the quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get the date and time when the stock was last updated.
	 *
	 * @return the last updated date and time
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Set the date and time when the stock was last updated.
	 *
	 * @param updatedAt the last updated date and time
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * Get the product associated with the stock.
	 *
	 * @return the associated product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Set the product associated with the stock.
	 *
	 * @param product the associated product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
}
