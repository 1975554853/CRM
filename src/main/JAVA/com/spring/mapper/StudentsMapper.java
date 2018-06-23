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

    Integer insertStudents(@Param("Name") String Name,@Param("Sex") String Sex,@Param("Age") String Age,@Param("Phone") String Phone,
                           @Param("StuStatus")String StuStatus,@Param("PerState") String PerState, @Param("MsgSource")String MsgSource,
                           @Param("SourceUrl") String SourceUrl,@Param("SourceKeyWord") String SourceKeyWord,@Param("QQ") String QQ,
                           @Param("WeiXin")String WeiXin,@Param("Content") String Content);

    List<String> selectaskersname();

    Integer updatenewStudent(@Param("ID") String ID,@Param("Name")String Name,@Param("Age")String Age,@Param("Sex")String Sex,
                             @Param("Phone")String Phone,@Param("AskerId")String AskerId, @Param("Address")String Address,
                             @Param("LearnForward")String LearnForward, @Param("Record")String Record,@Param("IsPay")String IsPay,
                             @Param("Content")String Content);

}