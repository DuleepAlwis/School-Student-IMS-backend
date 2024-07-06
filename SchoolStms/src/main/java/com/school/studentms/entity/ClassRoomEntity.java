package com.school.studentms.entity;

import lombok.Data;

@Data
public class ClassRoomEntity {

    private long id;
    private String code;
    private String location;
    private int capacity;
}
