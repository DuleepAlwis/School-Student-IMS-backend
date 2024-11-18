package com.school.studentms.dto;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@NoArgsConstructor
@ToString
public class UserDTO implements UserDetails {

	private long id;

	@NotEmpty(message = "Email is required")
	@Pattern(regexp = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}$", message = "Email should be valid")
	private String email;

	private String mobile;

	private String isActive;

	private String country;

	
	private long userRole;

	private long org;

	@NotEmpty(message="Password is required")
	private String password; 
	
	private LocalDateTime createdOn;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isActive.equals("Y")?true:false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isActive.equals("Y")?true:false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return UserDetails.super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return isActive.equals("Y")?true:false;
	}
}
