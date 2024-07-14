package com.school.studentms.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RoleEntity {


    private long id;

    private String roleName;

    private String isActive;

    private List<PermissionEntity> permissions;

    private List<UserEntity> users;

    private LocalDateTime createdOn;

}
