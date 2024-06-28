package com.school.studentms.dto;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrganizationDTO {

	
	private long id;
	
	private String orgName;
	
	private String city;
	
	private String address;
	
	private String district;
	
	private String orgCode;

	private boolean isActive;
	
	private List<UserDTO> users;

	private Date createdOn;
	
	
}
