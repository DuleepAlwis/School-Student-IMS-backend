package com.school.studentms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.studentms.config.JwtService;
import com.school.studentms.constants.ResponseMessage;
import com.school.studentms.dto.LoginDTO;
import com.school.studentms.dto.ResponseDTO;
import com.school.studentms.dto.TokenDTO;
import com.school.studentms.dto.UserDTO;
import com.school.studentms.entity.User;
import com.school.studentms.exception.TransactionFailedException;
import com.school.studentms.service.UserService;

import jakarta.validation.Valid;

@RequestMapping(value="/auth")
@RestController
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;

	@PostMapping(value = "/create")
	public ResponseEntity<ResponseDTO> create(@Valid @RequestBody UserDTO user, BindingResult result) {
		ResponseDTO response = new ResponseDTO();

		if (result.hasErrors()) {
			response.setStatus(false);
			response.setMessage(result.getFieldError("email").getDefaultMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		} else {
			try {
				user = userService.createUser(user);
				if (user != null) {
					response.setStatus(true);
					response.setMessage(ResponseMessage.USER_CREATION_SUCCESS);
					return new ResponseEntity<>(response, HttpStatus.CREATED);
				} else {
					throw new TransactionFailedException(ResponseMessage.USER_CREATION_FAILED);
				}
			} catch (TransactionFailedException e) {
				response.setStatus(false);
				response.setMessage(e.getMessage());
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@PostMapping(value="/login")
	public ResponseEntity<TokenDTO> login(@Valid @RequestBody LoginDTO loginDTO,BindingResult result) {
		TokenDTO token = new TokenDTO();
		if (result.hasErrors()) {
			token.setStatus(false);
			token.setMessage(result.getFieldError("email").getDefaultMessage());
            return new ResponseEntity<>(token, HttpStatus.BAD_REQUEST);

		}else {
			try {
				User authenticatedUser = userService.login(loginDTO.getEmail(), loginDTO.getPassword());
		        String jwtToken = jwtService.generateToken(authenticatedUser);
		        token.setEmail(loginDTO.getEmail());
		        token.setStatus(true);
		        token.setMessage("");
		        token.setId(authenticatedUser.getId());
		        token.setToken(jwtToken);
		        token.setExpiryTime(jwtService.getExpirationTime());
			}catch(TransactionFailedException e) {
				token.setStatus(false);
				token.setMessage(e.getMessage());
				return new ResponseEntity<>(token,HttpStatus.BAD_REQUEST);

			}
			return new ResponseEntity<>(token,HttpStatus.OK);
			
	        
		}

	}

}
