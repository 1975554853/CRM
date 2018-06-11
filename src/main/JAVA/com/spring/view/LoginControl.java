package com.spring.view;

import com.spring.auth.token.JSON_WEB_TOKEN;
import com.spring.auth.token.Token;
import com.spring.mapper.ModulesMapper;
import com.spring.page.Page;
import com.spring.pojo.Modules;
import com.spring.pojo.Users;
import com.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
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

    @Autowired
    Token tokenUtli;

    int mistake = 0;

    /**
     * 进行用户的登陆
     * @param userName 前台传入的用户名
     * @param passWord 前台传入的棉麻
     * @return 回馈给前台的信息
     */
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public Page login(@RequestParam("userName") String userName ,@RequestParam("passWord") String passWord) throws UnsupportedEncodingException {
        Users users = loginService.selectUserName(userName);

        if (users == null){
            return new Page(413 , "用户名不存在");
        }else if(!users.getPassword().equals(passWord)){
            if((users.getPsdwrongtime()+1)<3){
                loginService.updateUserPsdWrongTime(userName,"否",users.getPsdwrongtime()+1);
            }else{
                loginService.updateUserPsdWrongTime(userName,"是",users.getPsdwrongtime()+1);
            }
            return new Page(414 , "密码错误");
        }else if (users.getIslockout().equals("是")){
            return new Page(414 , "账户被锁定");
        }else{
            loginService.updateUserPsdWrongTime(userName,"否",0);
        }

        List<Modules> modules = modulesMapper.selectUserModules(userName , passWord);
//        session.setAttribute(SystemUtil.USER_MODULES , modules);

        JSON_WEB_TOKEN json_web_token = new JSON_WEB_TOKEN();
        json_web_token.setData(modules);
//        System.out.println(">>>>"+modules);

        Page result = new Page(666 , "登陆成功");
        result.setData(tokenUtli.createToken(json_web_token , 12*60*60*1000));
        return result;
    }

    @RequestMapping(value = "/index" , method = RequestMethod.POST)
    public Page showModules(String token) throws UnsupportedEncodingException {
//        System.out.println("查看session---"+token);
        List<Modules> userModule = (List<Modules>) tokenUtli.uncreateToken(JSON_WEB_TOKEN.class , token).getData();
//        System.out.println("-----"+userModule);
        return new Page(userModule , 666);
    }
}
