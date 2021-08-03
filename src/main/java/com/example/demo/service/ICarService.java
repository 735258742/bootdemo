package com.example.demo.service;

import com.example.demo.bean.Car;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface ICarService {
    List<Car> viewCar();
    List<Car> manageviewCar();
    Car selectCar(String carid);
    void deleteCar(String carid);
    void addCar(Car car);
    java.lang.Object modifyCar(String carid);
    boolean updateCar(@Param("car") Car car);

    void changerent(String carid);

    String selectrentpricebyid(String carid);
    String selectdepositbyid(String carid);
    int addorder(String username, String userid, String carid, String number, String type, String brand, String color, double rentprice, double deposit, double total, Date begintime, Date endtime,String img);

}
