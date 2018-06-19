package com.spring.service;

import com.spring.annotation.Annotation;
import com.spring.mapper.StudentsMapper;
import com.spring.pojo.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    StudentsMapper mapper;

    @Annotation(desc = "进行查询学生信息")
    public List<Students> selectStudent(String Studentname){
        if(Studentname.equals("")){
            Studentname=null;
        }
        return mapper.selectStudent(Studentname);
    }

    @Annotation(desc = "进行删除学生信息")
    public Integer deleteStudent(Integer id){
        return mapper.deleteByPrimaryKey(id);
    }



}
