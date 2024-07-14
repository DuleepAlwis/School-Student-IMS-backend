package com.school.studentms.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PermissionEntity {


    private long id;

    private String permissionName;

    private String isActive;



    List<RoleEntity> rolePermission;

    private LocalDateTime createdOn;

}
