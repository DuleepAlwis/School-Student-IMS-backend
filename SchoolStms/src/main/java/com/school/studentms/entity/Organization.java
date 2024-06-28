package com.school.studentms.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name="org_tb")
@Data
public class Organization {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="org_name", nullable = false)
	private String orgName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="address")
	private String address;
	
	@Column(name="district")
	private String district;
	
	@Column(name="org_code")
	private String orgCode;

	@Column(name="is_active")
	private boolean isActive;
	
	@OneToMany(mappedBy="org")
	private List<User> users;

	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="email", nullable = false)
	private String email;
	
	
}
