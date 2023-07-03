package com.jihad.project.OrderManagment.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jihad.project.OrderManagment.Authentication.AuthenticationRequest;
import com.jihad.project.OrderManagment.Authentication.AuthenticationResponse;
import com.jihad.project.OrderManagment.Authentication.RegisterRequest;
import com.jihad.project.OrderManagment.Repository.UserRepository;
import com.jihad.project.OrderManagment.Service.AuthenticationService;
import com.jihad.project.OrderManagment.model.Role;
import com.jihad.project.OrderManagment.model.User;
import com.jihad.project.OrderManagment.securityconfig.JwtService;

import lombok.RequiredArgsConstructor;

/**
 * Implementation of the {@link AuthenticationService} interface that handles
 * user authentication and registration.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * Registers a new user based on the provided {@link RegisterRequest}.
	 *
	 * @param registerRequest The {@link RegisterRequest} containing user
	 *                        registration details.
	 * @return The {@link AuthenticationResponse} with the generated token.
	 */
	@Override
	public AuthenticationResponse register(RegisterRequest registerRequest) {
		User user = createUserFromRegisterRequest(registerRequest);
		saveUser(user);
		String token = generateToken(user);
		return createAuthenticationResponse(token);
	}

	/**
	 * Saves the user to the database.
	 *
	 * @param user The user to be saved.
	 */
	private void saveUser(User user) {
		userRepository.save(user);
	}

	/**
	 * Generates a token for the authenticated user.
	 *
	 * @param user The authenticated user.
	 * @return The generated token.
	 */
	private String generateToken(User user) {
		return jwtService.generateToken(user);
	}

	/**
	 * Creates a new {@link User} object based on the provided
	 * {@link RegisterRequest}.
	 *
	 * @param registerRequest The {@link RegisterRequest} containing user
	 *                        registration details.
	 * @return The created {@link User} object.
	 */
	private User createUserFromRegisterRequest(RegisterRequest registerRequest) {
		String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
		return new User(registerRequest.getName(), registerRequest.getEmail(), encodedPassword, Role.USER);
	}

	/**
	 * Creates a new {@link AuthenticationResponse} with the provided token.
	 *
	 * @param token The authentication token.
	 * @return The created {@link AuthenticationResponse} object.
	 */
	private AuthenticationResponse createAuthenticationResponse(String token) {
		return new AuthenticationResponse(token);
	}

	/**
	 * Authenticates the user based on the provided {@link AuthenticationRequest}.
	 *
	 * @param request The {@link AuthenticationRequest} containing user
	 *                authentication details.
	 * @return The {@link AuthenticationResponse} with the generated token.
	 */
	@Override
	public AuthenticationResponse authenticateRequest(AuthenticationRequest request) {
		authenticateUser(request.getEmail(), request.getPassword());
		User user = findUserByEmail(request.getEmail());
		String token = generateToken(user);
		return createAuthenticationResponse(token);
	}

	/**
	 * Authenticates the user with the provided email and password using the
	 * {@link AuthenticationManager}.
	 *
	 * @param email    The user's email.
	 * @param password The user's password.
	 */
	private void authenticateUser(String email, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
	}

	/**
	 * Finds the user in the database based on the provided email.
	 *
	 * @param email The user's email.
	 * @return The found {@link User} object.
	 * @throws NoSuchElementException if the user is not found in the database.
	 */
	private User findUserByEmail(String email) {
		Optional<User> optionalUser = userRepository.findByEmail(email);
		return optionalUser.orElseThrow();
	}
}
