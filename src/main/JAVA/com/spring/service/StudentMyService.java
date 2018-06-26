package com.spring.service;

import com.spring.annotation.Annotation;
import com.spring.mapper.StudentsMapper;
import com.spring.pojo.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMyService {

    @Autowired
    StudentsMapper mapper;
    @Annotation(desc = "进行查询我的学生信息")
    public List<Students> selectStudent(List<String> roles,String name, String phone, String askUser, String inClassTime, String isReturnVisit, String isPay, String isValid, String sex){
        return mapper.selectMyStudent(roles,name,  phone,  askUser,  inClassTime,  isReturnVisit,  isPay,  isValid,  sex);
    }


}
