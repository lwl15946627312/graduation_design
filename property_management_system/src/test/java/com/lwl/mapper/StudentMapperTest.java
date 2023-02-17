package com.lwl.mapper;

import com.lwl.pojo.Student;
import com.lwl.service.impl.StudentServiceImpl;
import com.lwl.utils.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 李文龙
 * @version 1.0
 * @Create 2023-01-31-20:43
 * @Description com.lwl.mapper
 */
@SpringBootTest
public class StudentMapperTest {

    @Autowired
    StudentServiceImpl studentService;

    @Test
    public void studentLoginTest(){
        Student student = studentService.studentLogin("217003420101", "123456");
        System.out.println(student);
    }

    @Test
    public void queryAllStudentTest(){
//        List<Student> students = studentService.queryAllStudent();
//        System.out.println(students);
    }

    @Test
    public void addStudent(){
        int i = studentService.addStudent(Role.createUUID(),"赵莉", "123456", "女",
                "1999-01-01", "625874125412541254", "95874458745",
                "98547@ww.com", "广东省潮汕市", "217003410102", "管理系",
                "1班", "广东省", "2021-09-01", "null", "2-101",
                "a", "0", "0", Role.student);
        System.out.println(i);
    }

    @Test
    public void adminUpdateStudent(){
        studentService.adminUpdateStudent("b961d1e1f52c4bd5b22055cb0646b49e","柳柳", "123456",
                "1999-01-01", "625874125412541254", "95874458745",
                "98547@ww.com", "广东省潮汕市", "217003410102", "管理系",
                "1班", "广东省", "2021-09-01", "2-101",
                "a", "0", "0", Role.student);
    }

    @Test
    public void adminCheckOneStudentById(){
        Student student = studentService.checkOneStudentById("");
        System.out.println(student);
    }

    @Test
    public void adminDelStudent(){
        studentService.adminDelStudent("");
    }
}
