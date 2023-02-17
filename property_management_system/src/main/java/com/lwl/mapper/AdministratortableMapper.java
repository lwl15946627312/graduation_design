package com.lwl.mapper;

import com.lwl.pojo.Administratortable;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdministratortableMapper {

    /**
     *  登录
     * @param jobNumber 工号
     * @param password 密码
     * @return 管理员信息
     */
    Administratortable adminLogin(String jobNumber, String password);

    /**
     * 查看个人信息
     * @return 信息
     */
    Administratortable checkSelfMessage(int id);

    /**
     * 更改密码
     * @return ok
     */
    int adminUpdateMessage(int id,String password);

    /**
     * 上传照片
     * @return 信息
     */
    int adminUploadPhoto(int id,String photo);
}
