package com.example.demo.service.impl;

import com.example.demo.bean.Car;
import com.example.demo.mapper.CarMapper;
import com.example.demo.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CarServiceImpl implements ICarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> viewCar() {
        return carMapper.viewCar();
    }

    @Override
    public List<Car> manageviewCar(){return carMapper.manageviewCar();}

    @Override
    public Car selectCar(String carid) {
        return carMapper.selectCar(carid);
    }

    @Override
    public void deleteCar(String carid){carMapper.deleteCar(carid);}

    @Override
    public void addCar(Car car) {
        carMapper.addCar(car);
    }

    @Override
    public java.lang.Object modifyCar(String carid) { return carMapper.modifyCar(carid); }

    @Override
    public boolean updateCar(Car car){
        return carMapper.updateCar(car);
    }

    @Override
    public String selectrentpricebyid(String carid) {
        return carMapper.selectrentpricebyid(carid);
    }

    @Override
    public String selectdepositbyid(String carid) {
        return carMapper.selectdepositbyid(carid);
    }

    public int addorder(String username, String userid, String carid, String number, String type, String brand, String color, double rentprice, double deposit, double total, Date begintime, Date endtime,String img) {
        return carMapper.addorder(username,userid,carid,number,type,brand,color,rentprice,deposit,total,begintime,endtime,img);
    }

}
