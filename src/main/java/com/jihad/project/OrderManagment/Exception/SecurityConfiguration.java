package com.jihad.project.OrderManagment.Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jihad.project.OrderManagment.securityconfig.JwtAuthFilter;

import lombok.RequiredArgsConstructor;

/**
 * This class represents the security configuration for the Order Management
 * application.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

	@Autowired
	private JwtAuthFilter jwtAuthFilter;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	/**
	 * Creates the security filter chain.
	 *
	 * @param httpSecurity the HttpSecurity object used for configuring web security
	 * @return the configured SecurityFilterChain
	 * @throws Exception if an error occurs while configuring the security filter
	 *                   chain
	 */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().cors().and().authorizeHttpRequests().requestMatchers("/order/api/v1.0/**")
				.permitAll().anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
				.authenticationProvider(authenticationProvider);
		return httpSecurity.build();
	}
}
