package com.school.studentms.dao;

import com.school.studentms.entity.SystemPropEntity;

import java.util.List;

public interface SystemPropDAO {

    public long createSystemProp(SystemPropEntity systemPropEntity);
    public long updateSystemProp(SystemPropEntity systemPropEntity);
    public SystemPropEntity getSystemPropByName(String name);
    public SystemPropEntity getSystemPropById(long id);
    public List<SystemPropEntity> getAllSystemProp();
    public long deleteSystemProp(long id);
}
