package com.jihad.project.OrderManagment.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jihad.project.OrderManagment.DTO.ProductOrderDTO;
import com.jihad.project.OrderManagment.DTO.ProductOrderId;
import com.jihad.project.OrderManagment.Repository.ProductOrderRepository;
import com.jihad.project.OrderManagment.Service.ProductOrderService;
import com.jihad.project.OrderManagment.model.ProductOrder;

/**
 * Service implementation for managing Product Orders.
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {

	@Autowired
	private ProductOrderRepository productOrderRepository;

	/**
	 * Retrieves all product orders.
	 *
	 * @return a list of all product orders
	 */
	@Override
	public List<ProductOrderDTO> getAllProductOrders() {
		List<ProductOrder> productOrders = productOrderRepository.findAll();
		return productOrders.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * Retrieves a product order by its ID.
	 *
	 * @param id the ID of the product order
	 * @return an optional containing the product order, or empty if not found
	 */
	@Override
	public Optional<ProductOrderDTO> getProductOrderById(ProductOrderId id) {
		Optional<ProductOrder> productOrder = productOrderRepository.findById(id);
		return productOrder.map(this::convertToDTO);
	}

	/**
	 * Saves a product order.
	 *
	 * @param productOrderDTO the product order to be saved
	 * @return the saved product order
	 */
	@Override
	public ProductOrderDTO saveProductOrder(ProductOrderDTO productOrderDTO) {
		ProductOrder productOrder = convertToEntity(productOrderDTO);
		ProductOrder savedProductOrder = productOrderRepository.save(productOrder);
		return convertToDTO(savedProductOrder);
	}

	/**
	 * Deletes a product order by its ID.
	 *
	 * @param id the ID of the product order to be deleted
	 */
	@Override
	public void deleteProductOrder(ProductOrderId id) {
		productOrderRepository.deleteById(id);
	}

	/**
	 * Converts a ProductOrderDTO to a ProductOrder entity.
	 *
	 * @param productOrderDTO the ProductOrderDTO to be converted
	 * @return the converted ProductOrder entity
	 */
	private ProductOrder convertToEntity(ProductOrderDTO productOrderDTO) {
		ProductOrder productOrder = new ProductOrder();
		productOrder.setProductId(productOrderDTO.getProductId());
		productOrder.setOrderId(productOrderDTO.getOrderId());
		productOrder.setQuantity(productOrderDTO.getQuantity());
		return productOrder;
	}

	/**
	 * Converts a ProductOrder entity to a ProductOrderDTO.
	 *
	 * @param productOrder the ProductOrder entity to be converted
	 * @return the converted ProductOrderDTO
	 */
	private ProductOrderDTO convertToDTO(ProductOrder productOrder) {
		ProductOrderDTO productOrderDTO = new ProductOrderDTO();
		productOrderDTO.setProductId(productOrder.getProductId());
		productOrderDTO.setOrderId(productOrder.getOrderId());
		productOrderDTO.setQuantity(productOrder.getQuantity());
		return productOrderDTO;
	}
}
