package com.lwl.service.impl;

import com.lwl.mapper.AdministratortableMapper;
import com.lwl.pojo.Administratortable;
import com.lwl.service.AdministratortableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratortableServiceImpl implements AdministratortableService {

    @Autowired
    AdministratortableMapper administratortableMapper;

    /**
     *  登录
     * @param jobNumber 工号
     * @param password 密码
     * @return 管理员信息
     */
    @Override
    public Administratortable adminLogin(String jobNumber, String password) {
        return administratortableMapper.adminLogin(jobNumber, password);
    }

    /**
     * 查看个人信息
     * @return 信息
     */
    @Override
    public Administratortable checkSelfMessage(int id) {
        return administratortableMapper.checkSelfMessage(id);
    }

    /**
     * 更改密码
     * @return 信息
     */
    @Override
    public int adminUpdateMessage(int id, String password) {
        return administratortableMapper.adminUpdateMessage(id,password);
    }

    /**
     * 上传照片
     * @return ok
     */
    @Override
    public int adminUploadPhoto(int id, String photo) {
        return administratortableMapper.adminUploadPhoto(id,photo);
    }
}
