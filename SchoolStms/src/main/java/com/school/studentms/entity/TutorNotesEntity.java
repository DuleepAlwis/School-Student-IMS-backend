package com.school.studentms.entity;

import lombok.Data;

@Data
public class TutorNotesEntity {

    private long id;
    private String name;
    private String fileType;
    private String location;
    private long tutorId;
    private long subjectId;
}
