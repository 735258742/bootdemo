package com.example.demo.service.impl;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Param;

public interface IUserService {
    User login(@Param("username") String username, @Param("password") String password);
}
