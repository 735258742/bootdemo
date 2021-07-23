package com.example.demo.service.impl;

import com.example.demo.bean.Car;
import com.example.demo.mapper.CarMapper;
import com.example.demo.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
