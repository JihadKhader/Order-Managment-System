package com.jihad.project.OrderManagment.Authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the response object for authentication.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

	/**
	 * The authentication token.
	 */
	private String token;

	/**
	 * Constructs a new AuthenticationResponse with the given token.
	 *
	 * @param token the authentication token
	 */
	public AuthenticationResponse(String token) {
		this.token = token;
	}

	/**
	 * Returns the authentication token.
	 *
	 * @return the authentication token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the authentication token.
	 *
	 * @param token the authentication token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
}
