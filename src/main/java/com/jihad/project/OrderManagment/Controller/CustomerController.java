package com.jihad.project.OrderManagment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jihad.project.OrderManagment.DTO.CustomerDTO;
import com.jihad.project.OrderManagment.Exception.NotFoundException;
import com.jihad.project.OrderManagment.Service.CustomerService;

/**
 * Controller class for managing customer-related operations.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * Retrieve all customers.
	 *
	 * @return ResponseEntity containing a list of CustomerDTO objects
	 */
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
		List<CustomerDTO> customers = customerService.getAllCustomers();
		return ResponseEntity.ok(customers);
	}

	/**
	 * Retrieve a customer by ID.
	 *
	 * @param id the ID of the customer to retrieve
	 * @return ResponseEntity containing the CustomerDTO object
	 * @throws NotFoundException if the customer with the given ID is not found
	 */
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
		CustomerDTO customer = customerService.getCustomerById(id)
				.orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));
		return ResponseEntity.ok(customer);
	}

	/**
	 * Create a new customer.
	 *
	 * @param customer the CustomerDTO object representing the customer to be
	 *                 created
	 * @return ResponseEntity containing the created CustomerDTO object
	 */
	@PostMapping
	public ResponseEntity<CustomerDTO> createCustomer(@Validated @RequestBody CustomerDTO customer) {
		CustomerDTO createdCustomer = customerService.saveCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
	}

	/**
	 * Update an existing customer.
	 *
	 * @param id       the ID of the customer to update
	 * @param customer the CustomerDTO object representing the updated customer data
	 * @return ResponseEntity containing the updated CustomerDTO object
	 * @throws NotFoundException if the customer with the given ID is not found
	 */
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id,
			@Validated @RequestBody CustomerDTO customer) {
		CustomerDTO existingCustomer = customerService.getCustomerById(id)
				.orElseThrow(() -> new NotFoundException("Customer not found with id: " + id));

		// Update existingCustomer properties with customer request body

		CustomerDTO updatedCustomer = customerService.saveCustomer(existingCustomer);
		return ResponseEntity.ok(updatedCustomer);
	}

	/**
	 * Delete a customer by ID.
	 *
	 * @param id the ID of the customer to delete
	 * @return ResponseEntity with no content
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.noContent().build();
	}
}
