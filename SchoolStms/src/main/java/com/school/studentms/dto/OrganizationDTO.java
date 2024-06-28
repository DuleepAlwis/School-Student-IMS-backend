package com.school.studentms.dto;

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

	@Override
	public String toString() {
		return "OrganizationDTO [id=" + id + ", orgName=" + orgName + ", city=" + city + ", address=" + address
				+ ", district=" + district + ", orgCode=" + orgCode + ", isActive=" + isActive + ", users=" + users
				+ "]";
	}
	
	
}
