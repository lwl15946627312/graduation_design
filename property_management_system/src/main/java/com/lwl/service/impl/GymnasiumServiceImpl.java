package com.lwl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwl.mapper.GymnasiumMapper;
import com.lwl.pojo.Gymnasium;
import com.lwl.service.GymnasiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李文龙
 * @version 1.0
 * @Create 2023-02-04-0:33
 * @Description com.lwl.service
 */
@Service
public class GymnasiumServiceImpl implements GymnasiumService {

    @Autowired
    GymnasiumMapper gymnasiumMapper;

    /**
     * 分页查询所有场地
     * @param status 0空着的 1满了
     * @return 场地信息
     */
    @Override
    public PageInfo<Gymnasium> queryAllGymnasium(String status, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Gymnasium> gymnasiums = gymnasiumMapper.queryAllGymnasium(status);
        return new PageInfo<>(gymnasiums);
    }

    /**
     * 多条件查询场地
     * @return 场地信息
     */
    @Override
    public PageInfo<Gymnasium> queryAllGymnasiumByNameOrAddress(Integer pageNum,Integer pageSize,String name,String address,String department,String status){
        PageHelper.startPage(pageNum,pageSize);
        List<Gymnasium> gymnasiums = gymnasiumMapper.queryAllGymnasiumByNameOrAddress(name, address, status, department);
        return new PageInfo<>(gymnasiums);
    }

    /**
     * 预定场地
     * @return ok
     */
    @Override
    public int updateGymnasiumMessage(String id,String status, String department, String person, String role) {
        return gymnasiumMapper.updateGymnasiumMessage(id,status,department,person,role);
    }

    /**
     * 查询场地
     * @return ok
     */
    @Override
    public Gymnasium queryById(String id) {
        return gymnasiumMapper.queryById(id);
    }
}
