package com.spring.view;

import com.spring.auth.SystemUtil;
import com.spring.mapper.ModulesMapper;
import com.spring.page.Page;
import com.spring.pojo.Modules;
import com.spring.pojo.Users;
import com.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/toLog" , name = "用户登陆")
public class LoginControl {

    @Autowired
    LoginService loginService;

    @Autowired
    ModulesMapper modulesMapper;

    @Autowired
    HttpSession session;

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
            return new Page(413 , "用户名不存在");
        }

        Users users = loginService.selectOneUser(userName , passWord);
//        System.out.println(users);
        if(users == null){
            return new Page(414 , "密码错误");
        }else if (users.getIslockout().equals("是")){
            return new Page(414 , "账户被锁定");
        }

        List<Modules> modules = modulesMapper.selectUserModules(userName , passWord);
        session.setAttribute(SystemUtil.USER_MODULES , modules);

        Page result = new Page(666 , "登陆成功");
        result.setData(modules);
        return result;
    }

    @RequestMapping(value = "/index" , method = RequestMethod.POST)
    public Page showModules(){
        List<Modules> modules = (List<Modules>) session.getAttribute(SystemUtil.USER_MODULES);
        System.out.println("查看session---"+modules);
        return new Page(modules , 666);
    }
}
