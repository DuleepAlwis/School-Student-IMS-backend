package com.school.studentms.constants;

public interface Query {

    String GET_USER_BY_EMAIL = "Select * from user_tb where email=? and isActive='Y'";
    String GET_USER_BY_ID = "Select * from user_tb where id=? and isActive='Y'";
    String CREATE_NEW_USER = "Insert into user_tb(email,mobile,isActive,country,password,createdOn,roleId,orgId,otp,profile_pic) values(?,?,?,?,?,?,?,?,?,?)";
    String GET_MAX_ID_USER_TB = "Select max(id) as id from user_tb";
}
