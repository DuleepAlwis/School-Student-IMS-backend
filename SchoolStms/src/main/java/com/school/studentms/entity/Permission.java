package com.school.studentms.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="permission_tb")
@Data
public class Permission {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="permission_name")
	private String permissionName;
	
	@Column(name="is_active")
	private boolean isActive;

	
	@ManyToMany
	@JoinTable(
	  name = "role_permission_tb", 
	  joinColumns = @JoinColumn(name = "permission_id"), 
	  inverseJoinColumns = @JoinColumn(name = "role_id"))
	List<Role> rolePermission;
	
	@Column(name="created_on")
	private LocalDateTime createdOn;
	
	
	
	
}
