package com.lwl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwl.mapper.OrderMapper;
import com.lwl.pojo.Order;
import com.lwl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public PageInfo<Order> queryAllOrderMessage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> orders = orderMapper.queryAllOrderMessage();
        return new PageInfo<>(orders);
    }

    @Override
    public PageInfo<Order> querySelfOrderMessageByNameAndRoleAndDepartment(Integer pageNum, Integer pageSize, String name, String role, String department) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> orders = orderMapper.querySelfOrderMessageByNameAndRoleAndDepartment(name, role, department);
        return new PageInfo<>(orders);
    }

    @Override
    public PageInfo<Order> querySomeOrderMessage(Integer pageNum, Integer pageSize, String department, String role, String foodName) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> orders = orderMapper.querySomeOrderMessage(department, role, foodName);
        return new PageInfo<>(orders);
    }

    @Override
    public int addOrderMessage(String id, String name, String foodName, String price, String role, String department,String photo) {
        return orderMapper.addOrderMessage(id, name, foodName, price, role, department,photo);
    }

    @Override
    public int delOrderMessage(String id) {
        return orderMapper.delOrderMessage(id);
    }

    @Override
    public PageInfo<Order> querySelfOrderMessage(Integer pageNum, Integer pageSize, String name, String role, String department) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> orders = orderMapper.querySelfOrderMessage(name, role, department);
        return new PageInfo<>(orders);
    }
}
