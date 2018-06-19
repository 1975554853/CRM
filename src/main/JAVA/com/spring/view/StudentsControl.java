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







}
