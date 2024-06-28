package com.school.studentms.dto;

import com.school.studentms.entity.Role;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PermissionDTO {

	
	private long id;
	
	private String permissionName;
	
	private boolean isActive;

	private Role role;

	@Override
	public String toString() {
		return "PermissionDTO [id=" + id + ", permissionName=" + permissionName + ", isActive=" + isActive + ", role="
				+ role + "]";
	}
	
	
}
