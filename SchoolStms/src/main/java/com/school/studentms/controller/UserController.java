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

@RequestMapping(value = "/api/v1/user")
@RestController
public class UserController {

	
}
