package com.jihad.project.OrderManagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jihad.project.OrderManagment.model.Order;

/**
 * Repository interface for managing orders.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
