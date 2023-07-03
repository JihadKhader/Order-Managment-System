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

import com.jihad.project.OrderManagment.DTO.OrderDTO;
import com.jihad.project.OrderManagment.Exception.NotFoundException;
import com.jihad.project.OrderManagment.Service.OrderService;

import jakarta.validation.Valid;

/**
 * Controller class for managing orders.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	/**
	 * Retrieves a list of all orders.
	 *
	 * @return A ResponseEntity containing a list of all orders and a HttpStatus.OK
	 *         status code.
	 */
	@GetMapping
	public ResponseEntity<List<OrderDTO>> getAllOrders() {
		List<OrderDTO> orders = orderService.getAllOrders();
		return ResponseEntity.ok(orders);
	}

	/**
	 * Retrieves an order by its ID.
	 *
	 * @param id The ID of the order.
	 * @return A ResponseEntity containing the order with the specified ID and a
	 *         HttpStatus.OK status code, or a HttpStatus.NOT_FOUND status code if
	 *         the order is not found.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
		OrderDTO order = orderService.getOrderById(id)
				.orElseThrow(() -> new NotFoundException("Order not found with id: " + id));
		return ResponseEntity.ok(order);
	}

	/**
	 * Creates a new order.
	 *
	 * @param order The order to be created.
	 * @return A ResponseEntity containing the created order and a
	 *         HttpStatus.CREATED status code.
	 */
	@PostMapping
	public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderDTO order) {
		OrderDTO createdOrder = orderService.saveOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
	}

	/**
	 * Updates an existing order.
	 *
	 * @param id    The ID of the order to be updated.
	 * @param order The updated order.
	 * @return A ResponseEntity containing the updated order and a HttpStatus.OK
	 *         status code, or a HttpStatus.NOT_FOUND status code if the order is
	 *         not found.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @Validated @RequestBody OrderDTO order) {
		OrderDTO existingOrder = orderService.getOrderById(id)
				.orElseThrow(() -> new NotFoundException("Order not found with id: " + id));
		OrderDTO updatedOrder = orderService.saveOrder(existingOrder);
		return ResponseEntity.ok(updatedOrder);
	}

	/**
	 * Deletes an order by its ID.
	 *
	 * @param id The ID of the order to be deleted.
	 * @return A ResponseEntity with a HttpStatus.NO_CONTENT status code.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return ResponseEntity.noContent().build();
	}
}
