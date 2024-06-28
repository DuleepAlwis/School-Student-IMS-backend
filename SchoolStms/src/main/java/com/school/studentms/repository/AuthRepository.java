package com.school.studentms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.school.studentms.entity.User;

public interface AuthRepository extends JpaRepository<User, Long>{

	@Query(value="Select u from User u where u.email=?1")
	public User getUserByEmail(String email);
}
