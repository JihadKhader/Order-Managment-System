package com.jihad.project.OrderManagment.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Represents a customer in the order management system.
 */
@Entity
@Table(name = "Customer")
public class Customer {

	/**
	 * The unique identifier for the customer.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * The first name of the customer.
	 */
	@Column
	private String firstName;

	/**
	 * The last name of the customer.
	 */
	@Column
	private String lastName;

	/**
	 * The date of birth of the customer.
	 */
	@Column
	private Date bornAt;

	/**
	 * The list of orders associated with the customer.
	 */
	@JsonManagedReference
	@OneToMany
	private List<Order> orderList;

	/**
	 * Returns the unique identifier for the customer.
	 *
	 * @return The customer's unique identifier.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique identifier for the customer.
	 *
	 * @param id The customer's unique identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the first name of the customer.
	 *
	 * @return The customer's first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the customer.
	 *
	 * @param firstName The customer's first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns the last name of the customer.
	 *
	 * @return The customer's last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the customer.
	 *
	 * @param lastName The customer's last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the date of birth of the customer.
	 *
	 * @return The customer's date of birth.
	 */
	public Date getBornAt() {
		return bornAt;
	}

	/**
	 * Sets the date of birth of the customer.
	 *
	 * @param bornAt The customer's date of birth.
	 */
	public void setBornAt(Date bornAt) {
		this.bornAt = bornAt;
	}

	/**
	 * Returns the list of orders associated with the customer.
	 *
	 * @return The list of orders.
	 */
	public List<Order> getOrderList() {
		return orderList;
	}

	/**
	 * Sets the list of orders associated with the customer.
	 *
	 * @param orderList The list of orders.
	 */
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

}
