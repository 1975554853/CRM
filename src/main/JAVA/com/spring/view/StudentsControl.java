package com.spring.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.page.Page;
import com.spring.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/xsxx",name = "学生信息")
public class StudentsControl {

    @Autowired
    StudentsService studentsService;

    /**
     *查询学生信息
     * @param page
     * @param limit
     * @param Studentname 学生姓名
     * @return
     */
    @GetMapping(value = "/selectStudent",name = "查询学生信息")
    public Page selectStudent(Integer page,Integer limit,String Studentname){

        PageHelper.startPage(page,limit);
        PageInfo pageInfo=new PageInfo(studentsService.selectStudent(Studentname));
        Page pages=new Page();
        if(pageInfo.getTotal()>0){
            pages.setCode(100);
            pages.setMsg("查询成功");
            pages.setCount(pageInfo.getTotal());
            pages.setData(pageInfo.getList());
        }else {
            pages.setCode(101);
            pages.setMsg("查询失败");
        }
        return pages;
    }

    /**
     *删除学生信息
     * @param id 学生id
     * @return
     */
    @GetMapping(value = "/deleteStudent",name = "删除学生信息")
    public Page deleteStudent(Integer id){
        Integer n=studentsService.deleteStudent(id);
        Page pages=new Page();
        if(n>0){
            pages.setCode(100);
            pages.setMsg("删除成功");
        }else {
            pages.setCode(101);
            pages.setMsg("删除失败");
        }
        return pages;
    }

    /**
     *添加学生信息
     * @param Name 姓名
     * @param Sex 性别
     * @param Age 年龄
     * @param Phone 电话
     * @param StuStatus 学历
     * @param PerState 状态
     * @param MsgSource 来源渠道
     * @param SourceUrl 来源网站
     * @param SourceKeyWord 来源关键词
     * @param QQ qq
     * @param WeiXin 微信
     * @param Content 备注
     * @return
     */
    @GetMapping(value = "/insertStudents",name = "添加学生信息")
    public Page insertStudents(String Name,String Sex,String Age,String Phone,String StuStatus,String PerState,
            String MsgSource,String SourceUrl,String SourceKeyWord,String QQ,String WeiXin,String Content){

        Integer n=studentsService.insertStudents(Name,Sex,Age,Phone,StuStatus,PerState, MsgSource,SourceUrl,SourceKeyWord,QQ,WeiXin,Content);
        Page pages=new Page();
        if(n>0){
            pages.setCode(100);
            pages.setMsg("添加学生信息成功");
        }else {
            pages.setCode(101);
            pages.setMsg("添加学生信息失败");
        }
        return pages;
    }

    /**
     *查询所有老师名
     * @return
     */
    @GetMapping(value = "/selectaskersname")
    public Page selectaskersname(){
        Page pages=new Page();
        pages.setData(studentsService.selectaskersname());
        return pages;
    }

    /**
     * 修改学生信息
     * @param ID 学生id
     * @param Name 学生姓名
     * @param Age 学生年龄
     * @param Sex 学生性别
     * @param Phone 学生电话
     * @param AskerId 咨询师名
     * @param Address 学生所在地
     * @param LearnForward 学生课程方向
     * @param Record 学生得分
     * @param IsPay 学生是否缴费
     * @param Content 备注
     * @return
     */
    @GetMapping(value = "/updatenewStudent",name = "修改学生信息")
    public Page updatenewStudent(String ID,String Name,String Age,String Sex,String Phone,String AskerId,
                                 String Address,String LearnForward,String Record,String IsPay,String Content){

        //System.out.println(ID+","+Name+","+Age+","+Sex+","+Phone+","+AskerId+","+Address+","+LearnForward+","+Record+","+IsPay+","+Content);

        int n=studentsService.updatenewStudent(ID, Name, Age, Sex, Phone, AskerId, Address, LearnForward, Record, IsPay, Content);
        Page pages=new Page();
        if(n>0){
            pages.setCode(100);
            pages.setMsg("修改学生信息成功");
        }else {
            pages.setCode(101);
            pages.setMsg("修改学生信息失败");
        }
        return pages;
    }



}
