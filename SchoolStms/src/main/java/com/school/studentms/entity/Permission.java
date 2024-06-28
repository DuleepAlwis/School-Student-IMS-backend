package com.school.studentms.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

	@Column(name="role")
	@ManyToOne
	private Role role;
	
	@Column(name="created_on")
	private Date createdOn;
	
	
	
	
}
