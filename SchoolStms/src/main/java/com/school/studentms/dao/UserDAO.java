package com.school.studentms.dao;

import com.school.studentms.entity.UserEntity;

public interface UserDAO {

    public UserEntity getUserByEmail(String email);
    public UserEntity getUserById(long id);
    public long createUser(UserEntity ue);
    public long updateUser(UserEntity ue);
    public long changePassword(UserEntity ue);
    public long sendPasswordResetEmail(String email);
    public long deleteUser(long id);
}
