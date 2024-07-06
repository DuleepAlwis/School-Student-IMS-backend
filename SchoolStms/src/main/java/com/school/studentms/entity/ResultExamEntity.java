package com.school.studentms.entity;

import lombok.Data;

@Data
public class ResultExamEntity {

    private long id;
    private long studentId;
    private String year;
    private String semester;
    private String grade;
    private double marks;
    private String comment;
}
