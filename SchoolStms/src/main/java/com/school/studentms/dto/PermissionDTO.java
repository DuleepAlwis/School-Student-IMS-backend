package com.school.studentms.dto;

import java.util.Date;

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

	private Date createdOn;
	
}
