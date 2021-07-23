package com.example.demo.controller;

import com.example.demo.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarService carService;
    @GetMapping("viewCar")
    public String viewCar(HttpServletRequest request){
        request.setAttribute("cars",carService.viewCar());
        return "viewCar";
    }
    @GetMapping("selectCar")
    public String selectCar(String carid,HttpServletRequest request){
    request.setAttribute("cars",carService.selectCar(carid));
        return "selectCar";
    }
    @GetMapping("manageviewCar")
    public String manageCar(HttpServletRequest request){
        request.setAttribute("cars",carService.manageviewCar());
        return "manageviewCar";
    }
    @GetMapping("deleteCar")
    public String deleteCar(String carid,HttpServletRequest request){
    carService.deleteCar(carid);
    return "redirect:manageviewCar";
    }
}
