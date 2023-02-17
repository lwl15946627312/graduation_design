package com.lwl.mapper;

import com.lwl.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    /**
     * 查看所有订餐信息
     * @return 信息
     */
    List<Order> queryAllOrderMessage();

    /**
     * 查看自己的订餐信息
     * @return 信息
     */
    List<Order> querySelfOrderMessageByNameAndRoleAndDepartment(String name,String role,String department);

    /**
     * 条件查询信息
     * @return 信息
     */
    List<Order> querySomeOrderMessage(String department,String role,String foodName);

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
    List<Order> querySelfOrderMessage(String name,String role,String department);
}
