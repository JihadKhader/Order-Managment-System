package com.jihad.project.OrderManagment.DTO;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Represents a Customer Data Transfer Object (DTO) used for transferring
 * customer data.
 */
public class CustomerDTO {

	private Long id;
	private String firstName;
	private String lastName;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date bornAt;

	private List<OrderDTO> orderLists;

	/**
	 * Returns the ID of the customer.
	 *
	 * @return The ID of the customer.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the ID of the customer.
	 *
	 * @param id The ID of the customer.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the first name of the customer.
	 *
	 * @return The first name of the customer.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the customer.
	 *
	 * @param firstName The first name of the customer.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns the last name of the customer.
	 *
	 * @return The last name of the customer.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the customer.
	 *
	 * @param lastName The last name of the customer.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns the birth date of the customer.
	 *
	 * @return The birth date of the customer.
	 */
	public Date getBornAt() {
		return bornAt;
	}

	/**
	 * Sets the birth date of the customer.
	 *
	 * @param bornAt The birth date of the customer.
	 */
	public void setBornAt(Date bornAt) {
		this.bornAt = bornAt;
	}

	/**
	 * Returns the list of orders associated with the customer.
	 *
	 * @return The list of orders associated with the customer.
	 */
	public List<OrderDTO> getOrderLists() {
		return orderLists;
	}

	/**
	 * Sets the list of orders associated with the customer.
	 *
	 * @param orderLists The list of orders associated with the customer.
	 */
	public void setOrderLists(List<OrderDTO> orderLists) {
		this.orderLists = orderLists;
	}
}
