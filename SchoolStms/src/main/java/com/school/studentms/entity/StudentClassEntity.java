package com.school.studentms.entity;

import lombok.Data;

@Data
public class StudentClassEntity {

    private long id;
    private long studentId;
    private long classId;
    private String year;
    private String isActive;
}
