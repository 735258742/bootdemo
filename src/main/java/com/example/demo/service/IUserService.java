package com.example.demo.service;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserService {
    public List<User> viewUser();
    User login(@Param("username") String username, @Param("password") String password);

    int insertUser(User user);

    void setUser(String userid);

    void setRoot(String userid);

}
