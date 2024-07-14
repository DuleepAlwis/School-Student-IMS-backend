package com.school.studentms.service;

import com.school.studentms.dto.SystemPropDTO;
import com.school.studentms.entity.SystemPropEntity;

import java.util.List;

public interface SystemPropService {

    public long createSystemProp(SystemPropDTO systemPropDTO);
    public long updateSystemProp(SystemPropDTO systemPropDTO);
    public SystemPropDTO getSystemPropByName(String name);
    public SystemPropDTO getSystemPropById(long id);
    public List<SystemPropDTO> getAllSystemProp();
    public long deleteSystemProp(long id);

}
