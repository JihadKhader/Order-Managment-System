package com.jihad.project.OrderManagment.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jihad.project.OrderManagment.DTO.ProductOrderId;
import com.jihad.project.OrderManagment.model.ProductOrder;

/**
 * Repository interface for managing product orders.
 */
public interface ProductOrderRepository extends JpaRepository<ProductOrder, ProductOrderId> {
	Optional<ProductOrder> findByProductIdAndOrderId(Long productId, Long orderId);

}
