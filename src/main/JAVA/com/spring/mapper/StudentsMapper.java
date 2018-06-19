package com.spring.mapper;

import com.spring.pojo.Students;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Students record);

    int insertSelective(Students record);

    Students selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

    List<Students> selectStudent(@Param("Studentname") String Studentname);





}