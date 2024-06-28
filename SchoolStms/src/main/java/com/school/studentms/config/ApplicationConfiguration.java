package com.school.studentms.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.school.studentms.entity.User;
import com.school.studentms.repository.AuthRepository;

@Configuration
public class ApplicationConfiguration {
	private final AuthRepository authRepository;

	public ApplicationConfiguration(AuthRepository authRepository) {
		this.authRepository = authRepository;
	}

	/*
	 * @Bean UserDetailsService userDetailsService() {
	 * 
	 * User user = userRepository.getUserByEmail(username); if (user != null) {
	 * return (UserDetailsService) user; } else { throw new
	 * UsernameNotFoundException("User not found"); } }
	 */
	@Bean
    UserDetailsService userDetailsService() {
		/*
		 * return username ->
		 * Optional.ofNullable(authRepository.getUserByEmail(username)) .orElseThrow(()
		 * -> new UsernameNotFoundException("User not found"));
		 */
		return username -> authRepository.getUserByEmail(username);
    }

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}
}