package com.lwl.service;

import com.github.pagehelper.PageInfo;
import com.lwl.pojo.Order;

public interface OrderService {

    /**
     * 查看所有订餐信息 分页
     * @return 信息
     */
    PageInfo<Order> queryAllOrderMessage(Integer pageNum, Integer pageSize);

    /**
     * 查看自己的订餐信息 分页
     * @return 信息
     */
    PageInfo<Order> querySelfOrderMessageByNameAndRoleAndDepartment(Integer pageNum, Integer pageSize,String name, String role, String department);

    /**
     * 条件查询信息 分页
     * @return 信息
     */
    PageInfo<Order> querySomeOrderMessage(Integer pageNum, Integer pageSize,String department, String role, String foodName);

    /**
     * 添加订餐信息
     * @return ok
     */
    int addOrderMessage(String id,String name,String foodName,String price,String role,String department,String photo);

    /**
     * 删除订餐信息
     * @return ok
     */
    int delOrderMessage(String id);

    /**
     * 查看自己订单信息
     * @return 信息
     */
    PageInfo<Order> querySelfOrderMessage(Integer pageNum, Integer pageSize,String name, String role, String department);
}
