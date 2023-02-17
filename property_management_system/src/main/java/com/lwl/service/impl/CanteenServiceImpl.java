package com.lwl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwl.mapper.CanteenMapper;
import com.lwl.pojo.Canteen;
import com.lwl.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanteenServiceImpl implements CanteenService {

    @Autowired
    CanteenMapper canteenMapper;

    /**
     * 分页查询所有菜品
     * @return 菜品信息
     */
    @Override
    public PageInfo<Canteen> queryAllFood(Integer pageNum, Integer pageSize,String today) {
        PageHelper.startPage(pageNum,pageSize);
        List<Canteen> canteens = canteenMapper.queryAllFood(today);
        return new PageInfo<>(canteens);
    }

    /**
     * 今日菜品
     * @return 信息
     */
    @Override
    public PageInfo<Canteen> todayCanteenFood(Integer pageNum, Integer pageSize,String today) {
        PageHelper.startPage(pageNum,pageSize);
        List<Canteen> canteens = canteenMapper.todayCanteenFood(today);
        return new PageInfo<>(canteens);
    }

    /**
     * 查询菜品
     * @param name 菜名
     * @return 信息
     */
    @Override
    public PageInfo<Canteen> queryOneFoodByName(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Canteen> canteens = canteenMapper.queryOneFoodByName(name);
        return new PageInfo<>(canteens);
    }

    /**
     * 添加菜品
     * @return ok
     */
    @Override
    public int adminAddFoodToCanteen(String id, String name, String photo, String price, String today) {
        return canteenMapper.adminAddFoodToCanteen(id,name,photo,price,today);
    }

    /**
     * 删除菜品
     * @param id id
     * @return ok
     */
    @Override
    public int adminDelFoodFromCanteen(String id) {
        return canteenMapper.adminDelFoodFromCanteen(id);
    }

    /**
     * 删除今日菜品
     * @param id id
     * @param today 今天
     * @return ok
     */
    @Override
    public int adminDelTodayFood(String id,String today) {
        return canteenMapper.adminDelTodayFood(id,today);
    }

    /**
     * 通过id查询菜品
     * @return 信息
     */
    @Override
    public Canteen checkOneFoodById(String id) {
        return canteenMapper.checkOneFoodById(id);
    }
}
