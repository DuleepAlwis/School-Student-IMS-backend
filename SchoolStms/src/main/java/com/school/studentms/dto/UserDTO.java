package com.school.studentms.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

	private long id;

	@NotEmpty(message = "Email is required")
	@Pattern(regexp = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}$", message = "Email should be valid")
	private String email;

	private String mobile;

	private boolean isActive;

	private String country;

	
	private RoleDTO userRole;

	private OrganizationDTO org;

	@NotEmpty(message="Password is required")
	private String password; 
	
	private Date createdOn;
}
