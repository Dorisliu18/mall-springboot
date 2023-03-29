package com.dorisliu.mallspringboot.service.impl;

import com.dorisliu.mallspringboot.dao.UserDao;
import com.dorisliu.mallspringboot.dto.UserRegisterRequest;
import com.dorisliu.mallspringboot.service.UserService;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createdUser(userRegisterRequest);
    }
}
