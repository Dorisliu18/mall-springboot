package com.dorisliu.mallspringboot.service;

import com.dorisliu.mallspringboot.dto.UserRegisterRequest;
import model.User;

public interface UserService {

    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);
}
