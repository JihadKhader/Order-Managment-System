package com.jihad.project.OrderManagment.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jihad.project.OrderManagment.DTO.OrderDTO;
import com.jihad.project.OrderManagment.Repository.OrderRepository;
import com.jihad.project.OrderManagment.Service.OrderService;
import com.jihad.project.OrderManagment.model.Order;

/**
 * Implementation of the OrderService interface.
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	// @Auto Wired notation does this
	/**
	 * Constructor injection of OrderRepository.
	 *
	 * @param orderRepository the OrderRepository to be used
	 */
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	/**
	 * Get all orders.
	 *
	 * @return a list of OrderDTO objects representing all orders
	 */
	@Override
	public List<OrderDTO> getAllOrders() {
		List<Order> orders = orderRepository.findAll();
		return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * Convert an OrderDTO to an Order entity.
	 *
	 * @param orderDTO the OrderDTO to convert
	 * @return the converted Order entity
	 */
	private Order convertToEntity(OrderDTO orderDTO) {
		Order order = new Order();
		order.setId(orderDTO.getId());
		order.setOrderedAt(orderDTO.getOrderedAt());
		return order;
	}

	/**
	 * Get an order by ID.
	 *
	 * @param id the ID of the order to retrieve
	 * @return an Optional containing the OrderDTO if found, or an empty Optional if
	 *         not found
	 */
	@Override
	public Optional<OrderDTO> getOrderById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.map(this::convertToDTO);
	}

	/**
	 * Convert an Order entity to an OrderDTO.
	 *
	 * @param order the Order entity to convert
	 * @return the converted OrderDTO
	 */
	private OrderDTO convertToDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(order.getId());
		orderDTO.setOrderedAt(order.getOrderedAt());
		return orderDTO;
	}

	/**
	 * Save an order.
	 *
	 * @param orderDTO the OrderDTO to save
	 * @return the saved OrderDTO
	 */
	@Override
	public OrderDTO saveOrder(OrderDTO orderDTO) {
		Order order = convertToEntity(orderDTO);
		Order savedOrder = orderRepository.save(order);
		return convertToDTO(savedOrder);
	}

	/**
	 * Delete an order by ID.
	 *
	 * @param id the ID of the order to delete
	 */
	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}

}