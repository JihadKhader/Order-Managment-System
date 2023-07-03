package com.jihad.project.OrderManagment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jihad.project.OrderManagment.Authentication.AuthenticationRequest;
import com.jihad.project.OrderManagment.Authentication.AuthenticationResponse;
import com.jihad.project.OrderManagment.Authentication.RegisterRequest;
import com.jihad.project.OrderManagment.Service.AuthenticationService;

import lombok.RequiredArgsConstructor;

/**
 * Controller class for handling authentication-related requests.
 */
@RestController
@RequestMapping("order/api/v1.0/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	/**
	 * Registers a new user.
	 *
	 * @param registerRequest the register request containing user details
	 * @return the authentication response
	 */
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
		System.out.println(registerRequest.getEmail());
		return ResponseEntity.ok(authenticationService.register(registerRequest));
	}

	/**
	 * Authenticates a user.
	 *
	 * @param request the authentication request containing user credentials
	 * @return the authentication response
	 */
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticateRequest(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(authenticationService.authenticateRequest(request));
	}
}
