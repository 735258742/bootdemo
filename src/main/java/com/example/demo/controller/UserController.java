package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping("login")
    public String login(String username, String password) {
        User user = userService.login(username, password);
        if (user != null) {
            if (user.getIsroot().equals("0")) {
                return "redirect:home";
            } else {
                return "redirect:../car/manageviewCar";
            }

        } else {
            return "login";
        }

    }
    @GetMapping("home")
    public String home(){
        return "home";
    }
}