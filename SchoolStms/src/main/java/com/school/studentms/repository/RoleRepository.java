package com.school.studentms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.studentms.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}
