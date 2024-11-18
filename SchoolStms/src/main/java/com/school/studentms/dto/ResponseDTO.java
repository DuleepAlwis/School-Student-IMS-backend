package com.school.studentms.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ResponseDTO {

	private boolean status;
	private String message;
}
