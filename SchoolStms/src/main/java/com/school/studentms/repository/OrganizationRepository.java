package com.school.studentms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.studentms.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {

}
