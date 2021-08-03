package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.net.ssl.SSLEngine;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.file.Files;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("viewUser")
    public String viewUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.getAttribute("getusername");
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
        if (user.getUsername()==null||user.getPassword()==null){
            return "redirect:register";
        }
        else {
            user.setUsername(user.getUsername());
            user.setPassword(user.getPassword());
            user.setUserid(user.getUserid());
            //重名
            String username = request.getParameter("username");
            String usernameDB = userService.findUserNameByUserName(username);
            if (usernameDB != null){ return "error"; }
            // 对两次输入的密码进行校验
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");
            if (!password.equals(password2)) {
                return "error1";
            }
            else {
                userService.insertUser(user);
                return "redirect:login";
            }
        }
    }


    @RequestMapping("login")
    public String login(String username, String password,HttpServletRequest request) {
        User user = userService.login(username, password);
//        System.out.println("username:"+username);
        HttpSession session=request.getSession();


//        String getusername=user.getUsername();
//        System.out.println("getuserid:"+getuserid);
//        System.out.println("getusrname:"+getusername);
        session.setAttribute("user",user);
        session.setAttribute("username",username);

        if (user != null) {
//            String getuserid=user.getUserid();
////            String getusername=user.getUsername();
//            System.out.println(getuserid);
            session.setAttribute("getuserid",user.getUserid());
            System.out.println("获取的id："+user.getUserid());
            session.setAttribute("getusername",user.getUsername());
            if (user.getIsroot().equals("0")) {
                String denglu= (String) session.getAttribute("getusername");
                System.out.println("登录进来拿到的username:"+denglu);

                return "redirect:home";
            } else {
                return "redirect:managehome";
            }

        } else {
            return "login";
        }

    }
    @GetMapping("home")
    public String home(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
         session.getAttribute("getusername");
        return "home";
    }

    @GetMapping("managehome")
    public String managehome(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.getAttribute("getusername");
        return "managehome";
    }
}