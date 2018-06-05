package com.spring.view;

import com.spring.page.Page;
import com.spring.pojo.Users;
import com.spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/yh",name = "用户管理")
public class UserManagement {

    @Autowired
    UsersService usersService;

    /*
     * 根据查询条件检索用户信息：查询条件包括：
     * 用户名、创建起止时间,创建结束时间、是否锁定（1：是；2：否）、排序（创建时间、最后登录时间）
     */
    @GetMapping(value ="/selectUsersCondition",name = "条件检索")
    public Page selectUsersCondition(String loginname,String starttime,String endtime,String islockout,String sort){

        List<Users> l=usersService.selectUsersCondition(loginname,starttime,endtime,islockout,sort);

        Page page=new Page();

        return page;
    }
}
