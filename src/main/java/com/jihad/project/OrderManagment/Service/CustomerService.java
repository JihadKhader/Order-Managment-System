package com.jihad.project.OrderManagment.Service;

import java.util.List;
import java.util.Optional;

import com.jihad.project.OrderManagment.DTO.CustomerDTO;

/**
 * This interface defines the operations to be performed on customers.
 */
public interface CustomerService {

	/**
	 * Retrieves a list of all customers.
	 *
	 * @return A list of all customers.
	 */
	List<CustomerDTO> getAllCustomers();

	/**
	 * Retrieves a customer by their ID.
	 *
	 * @param id The ID of the customer.
	 * @return An Optional containing the customer, or an empty Optional if the
	 *         customer is not found.
	 */
	Optional<CustomerDTO> getCustomerById(Long id);

	/**
	 * Saves a new customer or updates an existing customer.
	 *
	 * @param customerDTO The customer to be saved or updated.
	 * @return The saved or updated customer.
	 */
	CustomerDTO saveCustomer(CustomerDTO customerDTO);

	/**
	 * Deletes a customer by their ID.
	 *
	 * @param id The ID of the customer to be deleted.
	 */
	void deleteCustomer(Long id);
}
