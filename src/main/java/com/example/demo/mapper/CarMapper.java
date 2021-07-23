package com.example.demo.mapper;

import com.example.demo.bean.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
    public List<Car> viewCar();
    Car selectCar(String carid);
}
