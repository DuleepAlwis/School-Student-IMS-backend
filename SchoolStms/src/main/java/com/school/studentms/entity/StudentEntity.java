package com.school.studentms.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentEntity {

    private long id;
    private String name;
    private LocalDate dob;
    private String gender;

}
