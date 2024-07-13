package com.school.studentms.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrganizationDTO {

	
	private long id;
	
	private String orgName;
	
	private String city;
	
	private String address;
	
	private String district;
	
	private String orgCode;

	private String isActive;
	
	private List<UserDTO> users;

	private LocalDateTime createdOn;
	
	private String profilePic;

	private String country;

	@NotEmpty(message = "Email is required")
	@Pattern(regexp = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}$", message = "Email should be valid")
	private String email;
}
