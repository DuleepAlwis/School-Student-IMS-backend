package com.school.studentms.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class RoleDTO {

	
	private long id;
	
	private String roleName;
	
	private boolean isActive;

	private List<PermissionDTO> permissions;

	private List<UserDTO> users;

	private LocalDateTime createdOn;
	
}
