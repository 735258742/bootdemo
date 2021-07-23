package com.example.demo.service;

import com.example.demo.bean.Car;

import java.util.List;

public interface ICarService {
    List<Car> viewCar();
    List<Car> manageviewCar();
    Car selectCar(String carid);

}
