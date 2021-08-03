package com.example.demo.mapper;

import com.example.demo.bean.Ordertable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

     List<Ordertable> viewOrder();

    List<Ordertable> selectOrder(String userid);
}
