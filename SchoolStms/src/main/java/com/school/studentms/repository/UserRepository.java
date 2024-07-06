/*
package com.school.studentms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.studentms.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	@Query(value="Select u from User u where u.email=?1")
	public User getUserByEmail(String email);
	
	
	
	@Query(value="Select u from User u where u.id=?1")
	public User getUserById(long id);
	
}
*/
