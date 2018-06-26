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
        System.out.println(Studentname);
        if(Studentname.equals("")){
            Studentname=null;
        }
        return mapper.selectStudent(Studentname);
    }


    @Annotation(desc = "进行删除学生信息")
    public Integer deleteStudent(Integer id){
        return mapper.deleteByPrimaryKey(id);
    }

    @Annotation(desc = "进行添加学生信息")
    public Integer insertStudents(String Name, String Sex, String Age, String Phone, String StuStatus, String PerState,
                                  String MsgSource, String SourceUrl, String SourceKeyWord, String QQ, String WeiXin, String Content){

//        System.out.println("1."+Name+";"+Sex+";"+Age+";"+Phone+";"+StuStatus+";"+PerState+";"+MsgSource+";"+
//                SourceUrl+";"+SourceKeyWord+";"+QQ+";"+WeiXin+";"+Content);
        Integer  n=0;
        n=mapper.insertStudents(Name,Sex,Age,Phone,StuStatus,PerState, MsgSource,SourceUrl,SourceKeyWord,QQ,WeiXin,Content);
        return n;
    }

    @Annotation(desc = "进行获得所有咨询师")
    public List<String> selectaskersname(){
        List<String> l=null;
        l=mapper.selectaskersname();
        return l;
    }

    @Annotation(desc = "进行修改学生信息")
    public Integer updatenewStudent(String ID,String Name,String Age,String Sex,String Phone,String AskerId,
                                    String Address,String LearnForward,String Record,String IsPay,String Content){
        Integer n=0;
        n=mapper.updatenewStudent(ID, Name, Age, Sex, Phone, AskerId, Address, LearnForward, Record, IsPay, Content);
        return n;
    }


}
