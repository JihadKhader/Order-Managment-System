package com.jihad.project.OrderManagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jihad.project.OrderManagment.model.Stock;

/**
 * Repository interface for managing stock.
 */
public interface StockRepository extends JpaRepository<Stock, Long> {

}
