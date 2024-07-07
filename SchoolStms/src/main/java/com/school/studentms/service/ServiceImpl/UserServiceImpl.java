package com.school.studentms.service.ServiceImpl;

import java.time.LocalDateTime;

import com.school.studentms.dao.UserDAO;
import com.school.studentms.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.studentms.constants.ResponseMessage;
import com.school.studentms.dto.UserDTO;
import com.school.studentms.entity.UserEntity;
import com.school.studentms.exception.TransactionFailedException;
import com.school.studentms.utility.ModelMapperConfig;
import com.school.studentms.utility.ApplicationUtility;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ModelMapperConfig modelMapper;

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Override
	@Transactional
	public long createUser(UserDTO user) {
		long result = 0;

		try {
			// Perform your transactional operations here
			UserEntity ue = new UserEntity();
			if (userDAO.getUserByEmail(user.getEmail()) == null) {
				user.setPassword(ApplicationUtility.generatePassword(user.getPassword()));
				user.setIsActive("Y");
				user.setCreatedOn(LocalDateTime.now());
				ue = modelMapper.modelMapper().map(user, UserEntity.class);
				result = userDAO.createUser(ue);
				logger.info("User creation of {} {}",user.getEmail(),result);
			} else {
				logger.info("User creation user exists {}",user.getEmail());
				throw new TransactionFailedException(ResponseMessage.EMAIL_EXISTS);
			}

		} catch (Exception e) {
			// Rollback the transaction and throw a custom exception
			logger.info("User creation error {} {}",user.getEmail(),e.getMessage());
			throw new TransactionFailedException("Transaction failed: " + e.getMessage());
		}
		return result;
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public long updateUser(UserDTO user) {
		UserEntity ue = new UserEntity();
		long result = 0;
		try {
			if(userDAO.getUserById(user.getId())!=null) {
				ue = modelMapper.modelMapper().map(user, UserEntity.class);
				result = userDAO.updateUser(ue);
			} else {
				throw new TransactionFailedException(ResponseMessage.EMAIL_EXISTS);
			}
		
		}catch(Exception e){
		// Rollback the transaction and throw a custom exception
			throw new TransactionFailedException("Transaction failed: " + e.getMessage());
		}
		return result;
	}

	@Override
	public long changePassword(UserDTO ue) {
		return 0;
	}

	@Override
	public long sendPasswordResetEmail(String email) {
		return 0;
	}

	@Override
	public long deleteUser(long id) {
		return 0;
	}

	@Transactional
	public UserDTO getUserById(long id) {
		UserDTO userDTO = null;
		try {
			UserEntity user = userDAO.getUserById(id);

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

	@Override
	@Transactional
	public UserDTO getUserByEmail(String email) {
		UserDTO userDTO = new UserDTO();
		try {
			UserEntity user = userDAO.getUserByEmail(email);
			if(user==null) {
				logger.warn("User doesn't exists {}",email);
				throw new TransactionFailedException(ResponseMessage.USER_DOES_NOT_EXISTS);
			}else {
				userDTO = modelMapper.modelMapper().map(user,UserDTO.class);
				userDTO.setPassword("");
				logger.info("User is in the system {}",email);
				return userDTO;
			}

		}catch(Exception e) {
			logger.error("Transaction didn't succeed {} {}",email,e.getMessage());
			throw new TransactionFailedException("Transaction failed: " + e.getMessage());
		}
	}
	
	@Transactional
	public UserDTO login(String email,String password) {
		UserEntity user = new UserEntity();
		UserDTO userDTO = null;
		try {
			 user = userDAO.getUserByEmail(email);

			if(user!=null && ApplicationUtility.passwordMatches(password,user.getPassword())) {
				userDTO = modelMapper.modelMapper().map(user, UserDTO.class);
				userDTO.setPassword("");
				logger.info("User login success {}",email);
				return userDTO;
			}else {
				logger.info("User login didn't success {}",email);
				throw new TransactionFailedException(ResponseMessage.LOGIN_FAILED);
			}
		}catch(Exception e) {
			logger.error("User login exception triggerred {} {}",email,e.getMessage());
			throw new TransactionFailedException(e.getMessage());
		}
		
	}
}
