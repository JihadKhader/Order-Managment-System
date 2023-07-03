package com.jihad.project.OrderManagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jihad.project.OrderManagment.model.Product;

/**
 * Repository interface for managing products.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
