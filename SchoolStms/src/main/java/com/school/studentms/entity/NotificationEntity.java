package com.school.studentms.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationEntity {

    private long id;
    private long userId;
    private String message;
    private LocalDateTime sendOn;
}
