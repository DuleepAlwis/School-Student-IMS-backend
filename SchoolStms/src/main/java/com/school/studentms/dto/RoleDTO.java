package com.school.studentms.dto;

import java.util.List;

import com.school.studentms.entity.Permission;
import com.school.studentms.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDTO {

	
	private long id;
	
	private String roleName;
	
	private boolean isActive;

	private List<PermissionDTO> permissions;

	private List<UserDTO> users;

	@Override
	public String toString() {
		return "RoleDTO [id=" + id + ", roleName=" + roleName + ", isActive=" + isActive + ", permissions="
				+ permissions + ", users=" + users + "]";
	}
	
	
}
