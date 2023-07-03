package com.jihad.project.OrderManagment.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jihad.project.OrderManagment.Repository.ProductRepository;
import com.jihad.project.OrderManagment.Service.ProductService;
import com.jihad.project.OrderManagment.model.Product;
import dto.ProductDTO;

/**
 * Implementation of the ProductService interface that provides methods for
 * managing products.
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	/**
	 * Retrieves a list of all products.
	 *
	 * @return A list of ProductDTO objects representing the products.
	 */
	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * Retrieves a product by its ID.
	 *
	 * @param id The ID of the product.
	 * @return An optional ProductDTO object representing the product, or an empty
	 *         optional if not found.
	 */
	@Override
	public Optional<ProductDTO> getProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product.map(this::convertToDTO);
	}

	/**
	 * Saves a product.
	 *
	 * @param productDTO The ProductDTO object representing the product to be saved.
	 * @return The saved ProductDTO object.
	 */
	@Override
	public ProductDTO saveProduct(ProductDTO productDTO) {
		Product product = convertToEntity(productDTO);
		Product savedProduct = productRepository.save(product);
		return convertToDTO(savedProduct);
	}

	/**
	 * Deletes a product by its ID.
	 *
	 * @param id The ID of the product to be deleted.
	 */
	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	/**
	 * Converts a Product object to a ProductDTO object.
	 *
	 * @param product The Product object to be converted.
	 * @return The corresponding ProductDTO object.
	 */
	private ProductDTO convertToDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setSlug(product.getSlug());
		productDTO.setName(product.getName());
		productDTO.setReference(product.getReference());
		productDTO.setPrice(product.getPrice());
		productDTO.setVat(product.getValue());
		productDTO.setStockable(product.getStockable());
		return productDTO;
	}

	/**
	 * Converts a ProductDTO object to a Product object.
	 *
	 * @param productDTO The ProductDTO object to be converted.
	 * @return The corresponding Product object.
	 */
	private Product convertToEntity(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setSlug(productDTO.getSlug());
		product.setName(productDTO.getName());
		product.setReference(productDTO.getReference());
		product.setPrice(productDTO.getPrice());
		product.setValue(productDTO.getVat());
		product.setStockable(productDTO.isStockable());
		return product;
	}
}
