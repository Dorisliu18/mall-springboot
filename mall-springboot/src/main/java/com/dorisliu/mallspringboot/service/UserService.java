package com.dorisliu.mallspringboot.service;

import com.dorisliu.mallspringboot.dto.UserLoginRequest;
import com.dorisliu.mallspringboot.dto.UserRegisterRequest;
import model.User;

public interface UserService {

    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);
    User login(UserLoginRequest userLoginRequest);
}
