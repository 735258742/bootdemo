package com.example.demo.controller;


import com.example.demo.bean.User;
import com.example.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
@RequestMapping
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("viewOrder")
    public String viewOrder(HttpServletRequest request){
        request.setAttribute("orders",orderService.viewOrder());
        return "viewOrder";
    }

    @GetMapping("selectOrder")
    public String selectOrder(String userid,HttpServletRequest request){
        HttpSession session=request.getSession();
        userid= (String) session.getAttribute("getuserid");
        System.out.println("userid1:"+userid);
        request.setAttribute("orders",orderService.selectOrder(userid));
        return "selectOrder";
    }
}
