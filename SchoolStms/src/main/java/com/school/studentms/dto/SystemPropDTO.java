package com.school.studentms.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class SystemPropDTO {
    private long id;
    private String name;
    private String value;
    private LocalDateTime createdOn;
}
