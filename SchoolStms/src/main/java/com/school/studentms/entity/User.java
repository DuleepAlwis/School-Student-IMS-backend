package com.school.studentms.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_tb")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="mobile_number")
	private String mobile;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="country")
	private String country;
	
	@Column(name="role")
	@ManyToOne
	private Role userRole;

	@Column(name="organization")
	@ManyToOne
	private Organization org;

	@Column(name="password")
	private String password;

	@Column(name="created_on")
	private Date createdOn;

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection<? extends GrantedAuthority>) List.of(userRole);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
	
	
	

}
