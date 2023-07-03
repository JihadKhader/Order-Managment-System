package com.jihad.project.OrderManagment.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jihad.project.OrderManagment.DTO.StockDTO;
import com.jihad.project.OrderManagment.Repository.StockRepository;
import com.jihad.project.OrderManagment.Service.StockService;
import com.jihad.project.OrderManagment.model.Stock;

/**
 * Implementation of the StockService interface for managing stocks.
 */
@Service
public class StockServiceImpl implements StockService {
	@Autowired
	private StockRepository stockRepository;

	/**
	 * Retrieves all stocks.
	 *
	 * @return A list of all stocks.
	 */
	@Override
	public List<StockDTO> getAllStocks() {
		List<Stock> stocks = stockRepository.findAll();
		return stocks.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	private StockDTO convertToDTO(Stock stock) {
		StockDTO stockDTO = new StockDTO();
		stockDTO.setId(stock.getId());
		stockDTO.setQuantity(stock.getQuantity());
		stockDTO.setUpdatedAt(stock.getUpdatedAt());
		return stockDTO;
	}

	/**
	 * Retrieves a stock by its ID.
	 *
	 * @param id The ID of the stock.
	 * @return An optional containing the stock if found, or an empty optional if
	 *         not found.
	 */
	@Override
	public Optional<StockDTO> getStockById(Long id) {
		Optional<Stock> stock = stockRepository.findById(id);
		return stock.map(this::convertToDTO);
	}

	/**
	 * Saves a stock.
	 *
	 * @param stockDTO The stock to save.
	 * @return The saved stock.
	 */
	@Override
	public StockDTO saveStock(StockDTO stockDTO) {
		Stock stock = convertToEntity(stockDTO);
		Stock savedStock = stockRepository.save(stock);
		return convertToDTO(savedStock);
	}

	private Stock convertToEntity(StockDTO stockDTO) {
		Stock stock = new Stock();
		stock.setId(stockDTO.getId());
		stock.setQuantity(stockDTO.getQuantity());
		stock.setUpdatedAt(stockDTO.getUpdatedAt());
		return stock;
	}

	/**
	 * Deletes a stock by its ID.
	 *
	 * @param id The ID of the stock to delete.
	 */
	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteById(id);
	}
}
