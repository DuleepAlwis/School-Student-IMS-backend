package com.school.studentms.service;

import com.school.studentms.dto.UserDTO;
import com.school.studentms.entity.UserEntity;

public interface UserService {

    public long createUser(UserDTO user);
    public UserDTO getUserById(long id);
    public UserDTO getUserByEmail(String email);
    public long updateUser(UserDTO ue);
    public long changePassword(UserDTO ue);
    public long sendPasswordResetEmail(String email);
    public long deleteUser(long id);
}
