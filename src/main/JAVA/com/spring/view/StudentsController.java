package com.spring.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.auth.token.JSON_WEB_TOKEN;
import com.spring.auth.token.Token;
import com.spring.page.Page;
import com.spring.service.StudentMyService;
import com.spring.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/student",name = "学生管理系统")
public class StudentsController {
    @Autowired
    StudentMyService studentMyService;
    @GetMapping(value = "/select",name = "查询所有我的学生")
    public Page selectMyStudent(Integer page,Integer limit,String token,String name, String phone, String askUser, String inClassTime, String isReturnVisit, String isPay, String isValid, String sex) throws UnsupportedEncodingException {
        JSON_WEB_TOKEN json_web_token = new Token().uncreateToken(JSON_WEB_TOKEN.class, token);
        List<String> roles = json_web_token.getRoles();
        PageHelper.startPage(page,limit);
        PageInfo pageInfo = new PageInfo(studentMyService.selectStudent(roles,name,  phone,  askUser,  inClassTime,  isReturnVisit,  isPay,  isValid,  sex));
        Page page1 = new Page(0,pageInfo.getTotal(),pageInfo.getList());
         return page1;
    }


}
