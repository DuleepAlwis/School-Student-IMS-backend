/*
package com.school.studentms.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="role_tb")
@Data
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="is_active")
	private boolean isActive;

	@ManyToMany(mappedBy="rolePermission")
	private List<Permission> permissions;

	@OneToMany(mappedBy="userRole")
	private List<User> users;

	@Column(name="created_on")
	private LocalDateTime createdOn;
	
	
	
	
	
}
*/
