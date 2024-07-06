package com.school.studentms.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SystemPropDTO {
    private long id;
    private String name;
    private String value;
    private LocalDateTime createdOn;
}
