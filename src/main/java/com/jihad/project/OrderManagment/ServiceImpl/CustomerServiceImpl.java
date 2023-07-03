package com.jihad.project.OrderManagment.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jihad.project.OrderManagment.DTO.CustomerDTO;
import com.jihad.project.OrderManagment.DTO.OrderDTO;
import com.jihad.project.OrderManagment.Repository.CustomerRepository;
import com.jihad.project.OrderManagment.Service.CustomerService;
import com.jihad.project.OrderManagment.model.Customer;
import com.jihad.project.OrderManagment.model.Order;

/**
 * Implementation of the CustomerService interface that provides operations to
 * manage customers.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	// @Auto Wired notation does this
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	/**
	 * Retrieves a list of all customers.
	 *
	 * @return A list of all customers.
	 */
	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	private OrderDTO convertOrderToDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(order.getId());
		orderDTO.setOrderedAt(order.getOrderedAt());
		return orderDTO;
	}

	/**
	 * Retrieves a customer by their ID.
	 *
	 * @param id The ID of the customer.
	 * @return An Optional containing the customer, or an empty Optional if the
	 *         customer is not found.
	 */
	@Override
	public Optional<CustomerDTO> getCustomerById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.map(this::convertToDTO);
	}

	private Order convertOrderToEntity(OrderDTO orderDTO) {
		Order order = new Order();
		order.setId(orderDTO.getId());
		order.setOrderedAt(orderDTO.getOrderedAt());
		return order;
	}

	/**
	 * Saves a new customer or updates an existing customer.
	 *
	 * @param customerDTO The customer to be saved or updated.
	 * @return The saved or updated customer.
	 */
	@Override
	public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
		Customer customer = convertToEntity(customerDTO);
		Customer savedCustomer = customerRepository.save(customer);
		return convertToDTO(savedCustomer);
	}

	private CustomerDTO convertToDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(customer.getId());
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		customerDTO.setBornAt(customer.getBornAt());
		customerDTO.setOrderLists(
				customer.getOrderList().stream().map(this::convertOrderToDTO).collect(Collectors.toList()));
		return customerDTO;
	}

	/**
	 * Deletes a customer by their ID.
	 *
	 * @param id The ID of the customer to be deleted.
	 */
	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}

	private Customer convertToEntity(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setId(customerDTO.getId());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setBornAt(customerDTO.getBornAt());
		customer.setOrderList(
				customerDTO.getOrderLists().stream().map(this::convertOrderToEntity).collect(Collectors.toList()));
		return customer;
	}
}
