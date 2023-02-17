package com.lwl.mapper;

import com.lwl.pojo.Teacher;
import com.lwl.service.impl.TeacherServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherMapperTest {

    @Autowired
    TeacherServiceImpl teacherService;

    @Test
    public void loginTest01(){
        Teacher login = teacherService.teacherLogin("95741585", "123456");
        System.out.println(login);
    }

    public void test(){
        Teacher teacher = new Teacher();
        teacher.getName();
        teacher.getDepartment();
        teacher.getPhone();
        teacher.getSex();
        teacher.getEmail();

    }
}
