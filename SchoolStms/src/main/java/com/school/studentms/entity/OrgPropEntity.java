package com.school.studentms.entity;

import lombok.Data;

@Data
public class OrgPropEntity {

    private long id;
    private long orgId;
    private long systemPropId;
    private String isActive;

}
