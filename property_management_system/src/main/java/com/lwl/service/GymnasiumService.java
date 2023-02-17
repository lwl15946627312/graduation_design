package com.lwl.service;

import com.github.pagehelper.PageInfo;
import com.lwl.pojo.Gymnasium;

public interface GymnasiumService {

    /**
     * 查询所有场地 分页
     * @return 场地信息
     */
    PageInfo<Gymnasium> queryAllGymnasium(String status,Integer pageNum,Integer pageSize);

    /**
     * 多条件查询所有的场地 分页
     * @return 场地信息
     */
    PageInfo<Gymnasium> queryAllGymnasiumByNameOrAddress(Integer pageNum,Integer pageSize,String name,String address,String department,String status);

    /**
     * 预定场地
     * @return ok
     */
    int updateGymnasiumMessage(String id,String status,String department,String person,String role);

    /**
     * 查询场地信息
     * @return ok
     */
    Gymnasium queryById(String id);
}
