package com.lwl.mapper;

import com.lwl.pojo.Canteen;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface CanteenMapper {

    /**
     * 查询所有餐厅食物
     * @return 食物信息
     */
    List<Canteen> queryAllFood(String today);

    /**
     * 今日菜单
     * @return 今日食堂菜品
     */
    List<Canteen> todayCanteenFood(String today);

    /**
     *增添食堂菜品
     * @return ok
     */
    int adminAddFoodToCanteen(String id,String name,String photo,String price,String today);

    /**
     * 条件查询菜品
     * @param name 菜名
     * @return 菜品信息
     */
    List<Canteen> queryOneFoodByName(String name);

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
