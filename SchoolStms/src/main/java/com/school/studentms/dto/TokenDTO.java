package com.school.studentms.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class TokenDTO {

	private String email;
	private boolean status;
	private String message;
	private String token;
	private long id;
	private long expiryTime;
}
