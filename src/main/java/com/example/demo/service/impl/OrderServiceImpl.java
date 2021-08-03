package com.example.demo.service.impl;

import com.example.demo.bean.Ordertable;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.IOrderService;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Ordertable> viewOrder() {
        return orderMapper.viewOrder();
    }

    @Override
    public List<Ordertable> selectOrder(String userid) {
        return orderMapper.selectOrder(userid);
    }
}
