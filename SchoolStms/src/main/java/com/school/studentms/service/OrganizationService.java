package com.school.studentms.service;

import com.school.studentms.dto.OrganizationDTO;

import java.util.List;

public interface OrganizationService {

    public long createOrganization(OrganizationDTO org);

    public long updateOrganization(OrganizationDTO org);

    public OrganizationDTO getOrganizationByEmail(String email);

    public OrganizationDTO getOrganizationById(long id);

    public List<OrganizationDTO> getAllOrganizations();

    public long deleteOrganization(long id);
}