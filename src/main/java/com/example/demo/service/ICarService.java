package com.example.demo.service;

import com.example.demo.bean.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICarService {
    List<Car> viewCar();
    List<Car> manageviewCar();
    Car selectCar(String carid);
    void deleteCar(String carid);
    void addCar(Car car);
    java.lang.Object modifyCar(String carid);
    boolean updateCar(@Param("car") Car car);

}
