package com.school.studentms.entity;

import lombok.Data;

@Data
public class SubjectClassEntity {

    private long id;
    private long subjectId;
    private long classId;
    private String isActive;
}
