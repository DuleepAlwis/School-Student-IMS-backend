package com.school.studentms.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LoginDTO {
	
	@NotEmpty(message = "Email is required")
	private String email;
	
	@NotEmpty(message = "Password is required")
	private String password;
	
}
