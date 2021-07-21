package com.example.demo.controller;

import com.example.demo.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("getUser.do")
    public User getUserById(String UserId){
        User user=new User();
        user.setUserId("1111");
        user.setUsername("wjl");
        user.setPassword("wjl1234");
        return user;
    }
}
