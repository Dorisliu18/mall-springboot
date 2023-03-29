package com.dorisliu.mallspringboot.dao;

import com.dorisliu.mallspringboot.dto.UserRegisterRequest;
import model.User;

public interface UserDao {

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createdUser(UserRegisterRequest userRegisterRequest);
}
