package com.jihad.project.OrderManagment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jihad.project.OrderManagment.model.Customer;

/**
 * Repository interface for managing customers.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
