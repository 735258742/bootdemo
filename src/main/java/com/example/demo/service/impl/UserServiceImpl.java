package com.example.demo.service.impl;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> viewUser(){return userMapper.viewUser();}

    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUserInfo(user);
    }

    @Override
    public void setUser(String userid){userMapper.setUser(userid);}

    @Override
    public void setRoot(String userid){userMapper.setRoot(userid);}

    @Override
    public String findUserNameByUserName(String username) {
        return userMapper.findUserNameByUserName(username);
    }
}