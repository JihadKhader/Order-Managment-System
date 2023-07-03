package com.jihad.project.OrderManagment.model;

import com.jihad.project.OrderManagment.DTO.ProductOrderId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents a product order in the order management system.
 */
@Entity
@Data
@Table
@IdClass(ProductOrderId.class)
public class ProductOrder {

	/**
	 * The unique identifier of the product in the order.
	 */
	@Id
	@Column(name = "product_id")
	private Long productId;

	/**
	 * The unique identifier of the order.
	 */
	@Id
	@Column(name = "order_id")
	private Long orderId;

	/**
	 * The quantity of the product in the order.
	 */
	@Column
	private int quantity;

	/**
	 * The price of the product.
	 */
	@Column
	private double price;

	/**
	 * The total value of the product order (quantity * price).
	 */
	@Column
	private double value;

	/**
	 * The product associated with the order.
	 */
	@ManyToOne
	@JoinColumn
	private Product product;

	/**
	 * The order associated with the product.
	 */
	@ManyToOne
	@JoinColumn
	private Order order;

	/**
	 * Retrieves the unique identifier of the product in the order.
	 *
	 * @return the product ID
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * Sets the unique identifier of the product in the order.
	 *
	 * @param productId the product ID to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * Retrieves the unique identifier of the order.
	 *
	 * @return the order ID
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * Sets the unique identifier of the order.
	 *
	 * @param orderId the order ID to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * Retrieves the quantity of the product in the order.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity of the product in the order.
	 *
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Retrieves the price of the product.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price of the product.
	 *
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Retrieves the total value of the product order (quantity * price).
	 *
	 * @return the total value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Sets the total value of the product order (quantity * price).
	 *
	 * @param value the total value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Retrieves the product associated with the order.
	 *
	 * @return the associated product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Sets the product associated with the order.
	 *
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Retrieves the order associated with the product.
	 *
	 * @return the associated order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Sets the order associated with the product.
	 *
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
}
