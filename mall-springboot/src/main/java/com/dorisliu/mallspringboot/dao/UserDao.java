package com.dorisliu.mallspringboot.dao;

import com.dorisliu.mallspringboot.dto.UserRegisterRequest;
import model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createdUser(UserRegisterRequest userRegisterRequest);
}
