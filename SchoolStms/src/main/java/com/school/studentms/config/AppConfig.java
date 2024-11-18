package com.school.studentms.config;

import com.school.studentms.dto.UserDTO;
import com.school.studentms.exception.ResourceNotFound;
import com.school.studentms.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class AppConfig {

    private static final Logger logger = LogManager.getLogger(AppConfig.class);

    @Autowired
    private UserService userService;

    @Bean
    public UserDetailsService userDetailsService() throws ResourceNotFound {

        return username -> {
            // Load user details from the database
            // This is just an example; replace it with your actual User repository logic
            logger.info("Inside user details service class {}",username);

            UserDTO user = userService.getUserByEmail(username);
            if (user == null) {
                throw new ResourceNotFound("User not found");
            }
            return user;

        };
    }
}
