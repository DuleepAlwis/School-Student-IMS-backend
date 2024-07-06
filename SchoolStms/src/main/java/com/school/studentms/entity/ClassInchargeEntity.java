package com.school.studentms.entity;

import lombok.Data;

@Data
public class ClassInchargeEntity {

    private long id;
    private long classId;
    private long tutorId;
    private String year;
    private String isActive;
}
