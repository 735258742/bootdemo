package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("viewUser")
    public String viewUser(HttpServletRequest request){
        request.setAttribute("users",userService.viewUser());
        return "viewUser";
    }

    @GetMapping("setRoot")
    public String setRoot(String userid){
        userService.setRoot(userid);
        return "redirect:viewUser";
    }

    @GetMapping("setUser")
    public String setUser(String userid){
        userService.setUser(userid);
        return "redirect:viewUser";
    }

    @RequestMapping("register")
    public String register() {
        return "register";
    }
    @RequestMapping("uregister")
    public String register(HttpServletRequest request, User user) throws Exception {
        if (user.getUsername()==null||user.getPassword()==null)
            throw new Exception("注册信息不能为空");
//        System.out.println("kkkkkkk");
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setUserid(user.getUserid());
        // 对两次输入的密码进行校验
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        if (!password.equals(password2))
            throw new Exception("两次输入的密码不一致");
        userService.insertUser(user);
        return "redirect:login";
    }


    @RequestMapping("login")
    public String login(String username, String password) {
        User user = userService.login(username, password);
        if (user != null) {
            if (user.getIsroot().equals("0")) {
                return "redirect:home";
            } else {
                return "redirect:managehome";
            }

        } else {
            return "login";
        }

    }
    @GetMapping("home")
    public String home(){
        return "home";
    }

    @GetMapping("managehome")
    public String managehome(){
        return "managehome";
    }
}