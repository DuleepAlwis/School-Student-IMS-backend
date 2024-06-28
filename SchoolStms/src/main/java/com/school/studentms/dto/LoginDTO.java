package com.school.studentms.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {
	
	@NotEmpty(message = "Email is required")
	private String email;
	
	@NotEmpty(message = "Password is required")
	private String password;
	
}
