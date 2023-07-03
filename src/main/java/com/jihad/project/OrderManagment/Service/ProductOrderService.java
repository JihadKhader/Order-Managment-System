package com.jihad.project.OrderManagment.Service;

import java.util.List;
import java.util.Optional;

import com.jihad.project.OrderManagment.DTO.ProductOrderDTO;
import com.jihad.project.OrderManagment.DTO.ProductOrderId;

/**
 * Service interface for managing product orders.
 */
public interface ProductOrderService {

	/**
	 * Get all product orders.
	 *
	 * @return a list of ProductOrderDTO objects representing all product orders
	 */
	List<ProductOrderDTO> getAllProductOrders();

	/**
	 * Get a product order by ID.
	 *
	 * @param id the ProductOrderId object representing the ID of the product order
	 *           to retrieve
	 * @return an Optional containing the ProductOrderDTO if found, or an empty
	 *         Optional if not found
	 */
	Optional<ProductOrderDTO> getProductOrderById(ProductOrderId id);

	/**
	 * Save a product order.
	 *
	 * @param productOrderDTO the ProductOrderDTO to save
	 * @return the saved ProductOrderDTO
	 */
	ProductOrderDTO saveProductOrder(ProductOrderDTO productOrderDTO);

	/**
	 * Delete a product order.
	 *
	 * @param id the ProductOrderId object representing the ID of the product order
	 *           to delete
	 */
	void deleteProductOrder(ProductOrderId id);

}