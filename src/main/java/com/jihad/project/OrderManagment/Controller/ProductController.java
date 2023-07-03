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

import com.jihad.project.OrderManagment.Exception.NotFoundException;
import com.jihad.project.OrderManagment.Service.ProductService;

import dto.ProductDTO;
import jakarta.validation.Valid;

/**
 * Controller class for managing products.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Retrieves a list of all products.
	 *
	 * @return A ResponseEntity containing a list of all products and a
	 *         HttpStatus.OK status code.
	 */
	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		List<ProductDTO> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	/**
	 * Retrieves a product by its ID.
	 *
	 * @param id The ID of the product.
	 * @return A ResponseEntity containing the product with the specified ID and a
	 *         HttpStatus.OK status code, or a HttpStatus.NOT_FOUND status code if
	 *         the product is not found.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
		ProductDTO product = productService.getProductById(id)
				.orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
		return ResponseEntity.ok(product);
	}

	/**
	 * Creates a new product.
	 *
	 * @param product The product to be created.
	 * @return A ResponseEntity containing the created product and a
	 *         HttpStatus.CREATED status code.
	 */
	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO product) {
		ProductDTO createdProduct = productService.saveProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	}

	/**
	 * Updates an existing product.
	 *
	 * @param id      The ID of the product to be updated.
	 * @param product The updated product.
	 * @return A ResponseEntity containing the updated product and a HttpStatus.OK
	 *         status code, or a HttpStatus.NOT_FOUND status code if the product is
	 *         not found.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @Validated @RequestBody ProductDTO product) {
		ProductDTO existingProduct = productService.getProductById(id)
				.orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
		ProductDTO updatedProduct = productService.saveProduct(existingProduct);
		return ResponseEntity.ok(updatedProduct);
	}

	/**
	 * Deletes a product by its ID.
	 *
	 * @param id The ID of the product to be deleted.
	 * @return A ResponseEntity with a HttpStatus.NO_CONTENT status code.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
}
