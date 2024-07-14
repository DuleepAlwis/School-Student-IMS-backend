package com.school.studentms.entity;

import lombok.Data;

@Data
public class TutorSubjectEntity {

    private long id;
    private long tutorId;
    private long subjectId;
    private String isActive;
}
