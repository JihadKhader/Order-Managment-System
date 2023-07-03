package com.jihad.project.OrderManagment.Service;

import com.jihad.project.OrderManagment.Authentication.AuthenticationRequest;
import com.jihad.project.OrderManagment.Authentication.AuthenticationResponse;
import com.jihad.project.OrderManagment.Authentication.RegisterRequest;

/**
 * Service interface for user authentication and registration.
 */
public interface AuthenticationService {

	/**
	 * Registers a new user.
	 *
	 * @param registerRequest the registration request containing user information
	 * @return the authentication response with the generated token
	 */
	AuthenticationResponse register(RegisterRequest registerRequest);

	/**
	 * Authenticates a user request.
	 *
	 * @param authenticationRequest the authentication request containing user
	 *                              credentials
	 * @return the authentication response with the generated token
	 */
	AuthenticationResponse authenticateRequest(AuthenticationRequest authenticationRequest);
}