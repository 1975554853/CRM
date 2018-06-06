package com.spring.view;

import com.spring.page.Page;
import com.spring.pojo.Users;
import com.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/toLog" , name = "用户登陆")
public class LoginControl {

    @Autowired
    LoginService loginService;

    /**
     * 进行用户的登陆
     * @param userName 前台传入的用户名
     * @param passWord 前台传入的棉麻
     * @return 回馈给前台的信息
     */
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public Page login(@RequestParam("userName") String userName ,@RequestParam("passWord") String passWord){
        Users name = loginService.selectUserName(userName);

        if (name == null){
            return new Page(404 , "用户名不存在");
        }

        Users users = loginService.selectOneUser(userName , passWord);
        System.out.println(users);
        if(users == null){
            return new Page(404 , "密码错误");
        }else if (users.getIslockout().equals("是")){
            return new Page(404 , "账户被锁定");
        }

        return new Page(666 , "登陆成功");
    }
}
