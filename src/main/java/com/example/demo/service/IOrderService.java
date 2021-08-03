package com.example.demo.service;

import com.example.demo.bean.Ordertable;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface IOrderService {

    List<Ordertable> viewOrder();

    List<Ordertable> selectOrder(String userid);
}
