package com.jihad.project.OrderManagment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jihad.project.OrderManagment.DTO.StockDTO;
import com.jihad.project.OrderManagment.Exception.NotFoundException;
import com.jihad.project.OrderManagment.Service.StockService;

import jakarta.validation.Valid;

/**
 * Controller class for managing stocks.
 */
//@Secured(value = { "" })
@EnableWebSecurity
@RestController
@RequestMapping("/stocks")
public class StockController {

	@Autowired
	private StockService stockService;

	/**
	 * Retrieves a list of all stocks.
	 *
	 * @return A ResponseEntity containing a list of all stocks and a HttpStatus.OK
	 *         status code.
	 */
	@GetMapping
	public ResponseEntity<List<StockDTO>> getAllStocks() {
		List<StockDTO> stocks = stockService.getAllStocks();
		return ResponseEntity.ok(stocks);
	}

	/**
	 * Retrieves a stock by its ID.
	 *
	 * @param id The ID of the stock.
	 * @return A ResponseEntity containing the stock with the specified ID and a
	 *         HttpStatus.OK status code, or a HttpStatus.NOT_FOUND status code if
	 *         the stock is not found.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<StockDTO> getStockById(@PathVariable Long id) {
		StockDTO stock = stockService.getStockById(id)
				.orElseThrow(() -> new NotFoundException("Stock not found with id: " + id));
		return ResponseEntity.ok(stock);
	}

	/**
	 * Creates a new stock.
	 *
	 * @param stock The stock to be created.
	 * @return A ResponseEntity containing the created stock and a
	 *         HttpStatus.CREATED status code.
	 */
	@PostMapping
	public ResponseEntity<StockDTO> createStock(@Valid @RequestBody StockDTO stock) {
		StockDTO createdStock = stockService.saveStock(stock);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdStock);
	}

	/**
	 * Updates an existing stock.
	 *
	 * @param id    The ID of the stock to be updated.
	 * @param stock The updated stock.
	 * @return A ResponseEntity containing the updated stock and a HttpStatus.OK
	 *         status code, or a HttpStatus.NOT_FOUND status code if the stock is
	 *         not found.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<StockDTO> updateStock(@PathVariable Long id, @Validated @RequestBody StockDTO stock) {
		StockDTO existingStock = stockService.getStockById(id)
				.orElseThrow(() -> new NotFoundException("Stock not found with id: " + id));

		// Update existingStock properties with stock request body

		StockDTO updatedStock = stockService.saveStock(existingStock);
		return ResponseEntity.ok(updatedStock);
	}

	/**
	 * Deletes a stock by its ID.
	 *
	 * @param id The ID of the stock to be deleted.
	 * @return A ResponseEntity with a HttpStatus.NO_CONTENT status code.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
		stockService.deleteStock(id);
		return ResponseEntity.noContent().build();
	}
}
