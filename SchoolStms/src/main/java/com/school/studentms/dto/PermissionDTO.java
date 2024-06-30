package com.school.studentms.dto;

import java.time.LocalDateTime;

import com.school.studentms.entity.Role;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PermissionDTO {

	
	private long id;
	
	private String permissionName;
	
	private boolean isActive;

	private Role role;

	private LocalDateTime createdOn;
	
}
