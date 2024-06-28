package com.school.studentms.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenDTO {

	private String email;
	private boolean status;
	private String message;
	private String token;
	private long id;
	private long expiryTime;
}
