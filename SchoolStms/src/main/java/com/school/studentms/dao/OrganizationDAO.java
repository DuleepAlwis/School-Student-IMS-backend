package com.school.studentms.dao;

import com.school.studentms.entity.OrganizationEntity;

import java.util.List;

public interface OrganizationDAO {

    public long createOrganization(OrganizationEntity org);

    public long updateOrganization(OrganizationEntity org);

    public OrganizationEntity getOrganizationByEmail(String email);

    public OrganizationEntity getOrganizationById(long id);

    public List<OrganizationEntity> getAllOrganizations();

    public long deleteOrganization(long id);
}
