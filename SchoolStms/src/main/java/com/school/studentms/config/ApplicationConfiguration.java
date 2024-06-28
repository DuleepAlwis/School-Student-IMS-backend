package com.school.studentms.config;

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
import com.school.studentms.repository.UserRepository;

@Configuration
public class ApplicationConfiguration {
	private final UserRepository userRepository;

	public ApplicationConfiguration(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Bean
	UserDetailsService userDetailsService(String username) {

		User user = userRepository.getUserByEmail(username);
		if (user != null) {
			return (UserDetailsService) user;
		} else {
			throw new UsernameNotFoundException("User not found");
		}
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
	AuthenticationProvider authenticationProvider(String username) {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService(username));
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}
}