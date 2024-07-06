package com.school.studentms.constants;

public interface Query {

    String GET_USER_BY_EMAIL = "Select * from user_tb where email=? and isActive='Y'";
    String GET_USER_BY_ID = "Select * from user_tb where id=? and isActive='Y'";
    String CREATE_NEW_USER = "Insert into user_tb(email,mobile,isActive,country,password,createdOn,roleId,orgId,otp,profile_pic) values(?,?,?,?,?,?,?,?,?,?)";
    String GET_ORG_BY_ID = "Select * from organization_tb where id=?";
    String GET_ORG_BY_EMAIL = "Select * from organization_tb where email=?";
    String CREATE_NEW_ORGANIZATION = "Insert into organization_tb(orgName,city,address,district,orgCode,isActive,createdOn,email,profile_pic)" +
            "values(?,?,?,?,?,?,?,?,?)";
    String GET_SYSTEM_PROP_BY_NAME = "Select id,name,value,createdOn from system_prop_tb where name=?";
}
