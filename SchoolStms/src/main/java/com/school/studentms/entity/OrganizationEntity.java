package com.school.studentms.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrganizationEntity {


    private long id;

    private String orgName;

    private String city;

    private String address;

    private String district;

    private String orgCode;

    private String isActive;

    private List<UserEntity> users;

    private LocalDateTime createdOn;

    private String email;

    private String profilePic;

    private String country;

}
