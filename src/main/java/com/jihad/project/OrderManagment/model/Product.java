package com.jihad.project.OrderManagment.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents a product in the order management system.
 */
@Entity
@Data
@Table(name = "Product")
public class Product {

	/**
	 * The unique identifier of the product.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * The slug for the product.
	 */
	@Column
	private String slug;

	/**
	 * The name of the product.
	 */
	@Column
	private String name;

	/**
	 * The reference code for the product.
	 */
	@Column
	private String reference;

	/**
	 * The price of the product.
	 */
	@Column
	private Double price;

	/**
	 * The value of the product.
	 */
	@Column
	private Double value;

	/**
	 * Indicates if the product is stockable.
	 */
	@Column
	private Boolean stockable;

	/**
	 * The list of stocks associated with the product.
	 */
	@OneToMany
	private List<Stock> stockList;

	/**
	 * The list of product orders associated with the product.
	 */
	@OneToMany
	private List<ProductOrder> productOrders;

	/**
	 * Retrieves the ID of the product.
	 *
	 * @return The ID of the product.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the ID of the product.
	 *
	 * @param id The ID of the product.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retrieves the slug for the product.
	 *
	 * @return The slug for the product.
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * Sets the slug for the product.
	 *
	 * @param slug The slug for the product.
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}

	/**
	 * Retrieves the name of the product.
	 *
	 * @return The name of the product.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the product.
	 *
	 * @param name The name of the product.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the reference code for the product.
	 *
	 * @return The reference code for the product.
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * Sets the reference code for the product.
	 *
	 * @param reference The reference code for the product.
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * Retrieves the price of the product.
	 *
	 * @return The price of the product.
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Sets the price of the product.
	 *
	 * @param price The price of the product.
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Retrieves the value of the product.
	 *
	 * @return The value of the product.
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * Sets the value of the product.
	 *
	 * @param value The value of the product.
	 */
	public void setValue(Double value) {
		this.value = value;
	}

	/**
	 * Checks if the product is stockable.
	 *
	 * @return true if the product is stockable, false otherwise.
	 */
	public Boolean getStockable() {
		return stockable;
	}

	/**
	 * Sets whether the product is stockable.
	 *
	 * @param stockable true if the product is stockable, false otherwise.
	 */
	public void setStockable(Boolean stockable) {
		this.stockable = stockable;
	}

	/**
	 * Retrieves the list of stocks associated with the product.
	 *
	 * @return The list of stocks associated with the product.
	 */
	public List<Stock> getStockList() {
		return stockList;
	}

	/**
	 * Sets the list of stocks associated with the product.
	 *
	 * @param stockList The list of stocks associated with the product.
	 */
	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

	/**
	 * Retrieves the list of product orders associated with the product.
	 *
	 * @return The list of product orders associated with the product.
	 */
	public List<ProductOrder> getProductOrders() {
		return productOrders;
	}

	/**
	 * Sets the list of product orders associated with the product.
	 *
	 * @param productOrders The list of product orders associated with the product.
	 */
	public void setProductOrders(List<ProductOrder> productOrders) {
		this.productOrders = productOrders;
	}
}
