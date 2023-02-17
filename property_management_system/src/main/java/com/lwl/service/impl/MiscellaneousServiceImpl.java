package com.lwl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwl.mapper.MiscellaneousMapper;
import com.lwl.pojo.Miscellaneous;
import com.lwl.service.MiscellaneousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiscellaneousServiceImpl implements MiscellaneousService {

    @Autowired
    MiscellaneousMapper miscellaneousMapper;

    /**
     * 查询全部信息
     * @return ok
     */
    @Override
    public PageInfo<Miscellaneous> adminQueryAllMiscellaneous(Integer pageNum, Integer pageSize, String logo) {
        PageHelper.startPage(pageNum,pageSize);
        List<Miscellaneous> miscellaneous = miscellaneousMapper.adminQueryAllMiscellaneous(logo);
        return new PageInfo<>(miscellaneous);
    }

    /**
     * 查询自己发出的信息
     * @return 信息
     */
    @Override
    public PageInfo<Miscellaneous> querySelfMiscellaneousByLogo(Integer pageNum, Integer pageSize, String logo, String createPerson,String identity) {
        PageHelper.startPage(pageNum,pageSize);
        List<Miscellaneous> miscellaneous = miscellaneousMapper.querySelfMiscellaneousByLogo(logo, createPerson,identity);
        return new PageInfo<>(miscellaneous);
    }

    /**
     * 查询全部收到的信息
     * @return 信息
     */
    @Override
    public PageInfo<Miscellaneous> queryReceivedMiscellaneousByLogo(Integer pageNum, Integer pageSize, String logo, String department, String look) {
        PageHelper.startPage(pageNum,pageSize);
        List<Miscellaneous> miscellaneous = miscellaneousMapper.queryReceivedMiscellaneousByLogo(logo, look, department);
        return new PageInfo<>(miscellaneous);
    }

    /**
     * 多条件查询信息
     * @return 信息
     */
    @Override
    public PageInfo<Miscellaneous> querySomeMiscellaneousByNameDepartment(Integer pageNum, Integer pageSize, String createPerson, String department) {
        PageHelper.startPage(pageNum,pageSize);
        List<Miscellaneous> miscellaneous = miscellaneousMapper.querySomeMiscellaneousByNameDepartment(createPerson, department);
        return new PageInfo<>(miscellaneous);
    }

    /**
     * 已解决
     * @return ok
     */
    @Override
    public int updateMiscellaneous(String id, String logo) {
        return miscellaneousMapper.updateMiscellaneous(id,logo);
    }

    /**
     * 插入信息
     * @return ok
     */
    @Override
    public int addMiscellaneousMessage(String id, String name, String department, String logo, String identity, String createPerson, String look) {
        return miscellaneousMapper.addMiscellaneousMessage(id,name,department,logo,identity,createPerson,look);
    }

    /**
     * 删除信息
     * @return ok
     */
    @Override
    public int delMiscellaneousMessage(String id) {
        return miscellaneousMapper.delMiscellaneousMessage(id);
    }
}
