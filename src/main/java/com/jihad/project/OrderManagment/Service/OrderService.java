package com.jihad.project.OrderManagment.Service;

import java.util.List;
import java.util.Optional;

import com.jihad.project.OrderManagment.DTO.OrderDTO;

/**
 * Service interface for managing orders.
 */
public interface OrderService {

	/**
	 * Get all orders.
	 *
	 * @return a list of OrderDTO objects representing all orders
	 */
	List<OrderDTO> getAllOrders();

	/**
	 * Get an order by ID.
	 *
	 * @param id the ID of the order to retrieve
	 * @return an Optional containing the OrderDTO if found, or an empty Optional if
	 *         not found
	 */
	Optional<OrderDTO> getOrderById(Long id);

	/**
	 * Save an order.
	 *
	 * @param orderDTO the OrderDTO to save
	 * @return the saved OrderDTO
	 */
	OrderDTO saveOrder(OrderDTO orderDTO);

	/**
	 * Delete an order by ID.
	 *
	 * @param id the ID of the order to delete
	 */
	void deleteOrder(Long id);

}