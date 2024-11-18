package com.school.studentms.dto;

import java.time.LocalDateTime;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class PermissionDTO {

	
	private long id;
	
	private String permissionName;
	
	private boolean isActive;

	private long role;

	private LocalDateTime createdOn;
	
}
