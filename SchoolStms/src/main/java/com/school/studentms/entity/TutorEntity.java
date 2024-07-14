package com.school.studentms.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TutorEntity {

    private long id;
    private String name;
    private String address;
    private String city;
    private String district;
    private long userId;
    private String qualification1;
    private String description;
    private LocalDate dob;
    private String gender;
}
