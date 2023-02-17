package com.lwl.service;

import com.github.pagehelper.PageInfo;
import com.lwl.pojo.Canteen;

/**
 * @author 李文龙
 * @version 1.0
 * @Create 2023-02-03-20:53
 * @Description com.lwl.service
 */
public interface CanteenService {

    /**
     * 查询所有餐厅食物 分页
     * @return 食物信息
     */
    PageInfo<Canteen> queryAllFood(Integer pageNum,Integer pageSize,String today);

    /**
     * 今日菜单 分页
     * @return 今日食堂菜品
     */
    PageInfo<Canteen> todayCanteenFood(Integer pageNum,Integer pageSize,String today);

    /**
     * 条件查询菜品 分页
     * @param name 菜名
     * @return 菜品信息
     */
    PageInfo<Canteen> queryOneFoodByName(Integer pageNum,Integer pageSize,String name);

    /**
     *增添食堂菜品
     * @return ok
     */
    int adminAddFoodToCanteen(String id,String name,String photo,String price,String today);

    /**
     * 删除菜品
     * @param id id
     * @return ok
     */
    int adminDelFoodFromCanteen(String id);

    /**
     * 清除今日菜品
     * @param today 今天
     * @return ok
     */
    int adminDelTodayFood(String id,String today);

    /**
     * 查询一个食物
     * @return 信息
     */
    Canteen checkOneFoodById(String id);
}
