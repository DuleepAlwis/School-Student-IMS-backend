package com.school.studentms.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SystemPropEntity {

    private long id;
    private String name;
    private String value;
    private LocalDateTime createdOn;
}
