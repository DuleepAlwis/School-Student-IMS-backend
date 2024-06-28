package com.school.studentms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.school.studentms.constants.ResponseMessage;
import com.school.studentms.dto.UserDTO;
import com.school.studentms.entity.User;
import com.school.studentms.exception.TransactionFailedException;
import com.school.studentms.repository.UserRepository;
import com.school.studentms.utility.ModelMapperConfig;
import com.school.studentms.utility.PasswordUtility;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapperConfig modelMapper;

    
	@Transactional
	public UserDTO createUser(UserDTO user) {

		try {
			// Perform your transactional operations here
			User ue = new User();
			if (userRepository.getUserByEmail(user.getEmail()) == null) {
				user.setPassword(PasswordUtility.generatePassword(user.getPassword()));
				ue = modelMapper.modelMapper().map(user, User.class);
				user = modelMapper.modelMapper().map(userRepository.save(ue), UserDTO.class);
			} else {
				throw new TransactionFailedException(ResponseMessage.EMAIL_EXISTS);
			}

		} catch (Exception e) {
			// Rollback the transaction and throw a custom exception
			throw new TransactionFailedException("Transaction failed: " + e.getMessage());
		}
		return user;
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public UserDTO updateUser(UserDTO user) {
		User ue = new User();
		try {
			if(userRepository.getUserById(user.getId())!=null) {
				ue = modelMapper.modelMapper().map(user, User.class);
				user = modelMapper.modelMapper().map(userRepository.save(ue),UserDTO.class);
			} else {
				throw new TransactionFailedException(ResponseMessage.EMAIL_EXISTS);
			}
		
		}catch(Exception e){
		// Rollback the transaction and throw a custom exception
			throw new TransactionFailedException("Transaction failed: " + e.getMessage());
		}
		return user;
	}
	
	@Transactional
	public UserDTO getUserById(long id) {
		UserDTO userDTO = new UserDTO();
		try {
			User user = userRepository.getUserById(id);
			if(user==null) {
				throw new TransactionFailedException(ResponseMessage.USER_DOES_NOT_EXISTS);
			}else {
				userDTO = modelMapper.modelMapper().map(user,UserDTO.class);

			}
			
		}catch(Exception e) {
			throw new TransactionFailedException("Transaction failed: " + e.getMessage());
		}
		return userDTO;
	}

	@Transactional
	public UserDTO getUserByEmail(String email) {
		UserDTO userDTO = new UserDTO();
		try {
			User user = userRepository.getUserByEmail(email);
			if(user==null) {
				throw new TransactionFailedException(ResponseMessage.USER_DOES_NOT_EXISTS);
			}else {
				userDTO = modelMapper.modelMapper().map(user,UserDTO.class);

			}
			
		}catch(Exception e) {
			throw new TransactionFailedException("Transaction failed: " + e.getMessage());
		}
		return userDTO;
	}
	
	@Transactional
	public User login(String email,String password) {
		User user = new User();
		try {
			 user = userRepository.getUserByEmail(email);
			if(user!=null && PasswordUtility.passwordMatches(password,user.getPassword())) {
				return user;
			}else {
				throw new TransactionFailedException(ResponseMessage.LOGIN_FAILED);
			}
		}catch(Exception e) {
			throw new TransactionFailedException(e.getMessage());
		}
		
	}
}
