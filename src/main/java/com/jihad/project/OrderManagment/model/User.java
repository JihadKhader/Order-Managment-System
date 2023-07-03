package com.jihad.project.OrderManagment.model;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * Model class representing a user.
 */
@SuppressWarnings("serial")
@Entity
@Builder
@AllArgsConstructor
@Table
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String password;

	@Column
	private Role role;

	/**
	 * Constructs a User object with the specified parameters.
	 *
	 * @param id       the ID of the user
	 * @param name     the name of the user
	 * @param email    the email of the user
	 * @param password the password of the user
	 * @param role     the role of the user
	 */
	public User(Long id, String name, String email, String password, Role role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	/**
	 * Default constructor for the User class.
	 */
	public User() {

	}

	/**
	 * Constructs a User object with the specified parameters.
	 *
	 * @param name            the name of the user
	 * @param email           the email of the user
	 * @param encodedPassword the encoded password of the user
	 * @param role            the role of the user
	 */
	public User(String name, String email, String encodedPassword, Role role) {
		this.name = name;
		this.email = email;
		this.password = encodedPassword;
		this.role = role;
	}

	/**
	 * Returns the authorities granted to the user.
	 *
	 * @return a collection of granted authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	/**
	 * Returns the password used to authenticate the user.
	 *
	 * @return the password
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * Returns the username used to authenticate the user.
	 *
	 * @return the username
	 */
	@Override
	public String getUsername() {
		return email;
	}

	/**
	 * Indicates whether the user's account has expired.
	 *
	 * @return true if the user's account is valid (not expired), false otherwise
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Indicates whether the user is locked or unlocked.
	 *
	 * @return true if the user is not locked, false otherwise
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Indicates whether the user's credentials (password) has expired.
	 *
	 * @return true if the user's credentials are valid (not expired), false
	 *         otherwise
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Indicates whether the user is enabled or disabled.
	 *
	 * @return true if the user is enabled, false otherwise
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
}
