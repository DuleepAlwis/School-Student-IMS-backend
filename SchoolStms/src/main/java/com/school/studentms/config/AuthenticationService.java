/*
 * package com.school.studentms.config;
 * 
 * import org.springframework.security.authentication.AuthenticationManager;
 * import org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.stereotype.Service;
 * 
 * import com.school.studentms.dto.LoginDTO; import
 * com.school.studentms.entity.User; import
 * com.school.studentms.repository.UserRepository;
 * 
 * @Service public class AuthenticationService { private final UserRepository
 * userRepository;
 * 
 * private final PasswordEncoder passwordEncoder;
 * 
 * private final AuthenticationManager authenticationManager;
 * 
 * public AuthenticationService(UserRepository userRepository,
 * AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder)
 * { this.authenticationManager = authenticationManager; this.userRepository =
 * userRepository; this.passwordEncoder = passwordEncoder; }
 * 
 * public User signup(UserDTO input) { User user = new
 * User().setFullName(input.getFullName()).setEmail(input.getEmail())
 * .setPassword(passwordEncoder.encode(input.getPassword()));
 * 
 * return userRepository.save(user); }
 * 
 * public User authenticate(LoginDTO input) { authenticationManager
 * .authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(),
 * input.getPassword()));
 * 
 * return userRepository.getUserByEmail(input.getEmail()).orElseThrow(); } }
 */