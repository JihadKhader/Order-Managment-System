package com.jihad.project.OrderManagment.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jihad.project.OrderManagment.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * Retrieves a user by their email.
	 *
	 * @param email the email of the user to retrieve
	 * @return an optional containing the user, or empty if not found
	 */
	Optional<User> findByEmail(String email);

}
