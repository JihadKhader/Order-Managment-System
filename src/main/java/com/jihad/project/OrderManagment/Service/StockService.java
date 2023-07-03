package com.jihad.project.OrderManagment.Service;

import java.util.List;
import java.util.Optional;
import com.jihad.project.OrderManagment.DTO.StockDTO;

/**
 * Interface for managing stocks.
 */
public interface StockService {

	/**
	 * Retrieves all stocks.
	 *
	 * @return A list of all stocks.
	 */
	List<StockDTO> getAllStocks();

	/**
	 * Retrieves a stock by its ID.
	 *
	 * @param id The ID of the stock.
	 * @return An optional containing the stock if found, or an empty optional if
	 *         not found.
	 */
	Optional<StockDTO> getStockById(Long id);

	/**
	 * Saves a stock.
	 *
	 * @param stockDTO The stock to save.
	 * @return The saved stock.
	 */
	StockDTO saveStock(StockDTO stockDTO);

	/**
	 * Deletes a stock by its ID.
	 *
	 * @param id The ID of the stock to delete.
	 */
	void deleteStock(Long id);
}