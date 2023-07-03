package com.jihad.project.OrderManagment.Service;

import java.util.List;
import java.util.Optional;

import dto.ProductDTO;

/**
 * Service interface for managing products.
 */
public interface ProductService {

	/**
	 * Retrieves a list of all products.
	 *
	 * @return A list of ProductDTO objects representing the products.
	 */
	List<ProductDTO> getAllProducts();

	/**
	 * Retrieves a product by its ID.
	 *
	 * @param id The ID of the product.
	 * @return An optional ProductDTO object representing the product, or an empty
	 *         optional if not found.
	 */
	Optional<ProductDTO> getProductById(Long id);

	/**
	 * Saves a product.
	 *
	 * @param productDTO The ProductDTO object representing the product to be saved.
	 * @return The saved ProductDTO object.
	 */
	ProductDTO saveProduct(ProductDTO productDTO);

	/**
	 * Deletes a product by its ID.
	 *
	 * @param id The ID of the product to be deleted.
	 */
	void deleteProduct(Long id);
}
