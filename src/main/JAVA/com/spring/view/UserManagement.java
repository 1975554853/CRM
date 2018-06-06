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
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/yh",name = "用户管理")
public class UserManagement {

    @Autowired
    UsersService usersService;

    /**
     * 根据查询条件检索用户信息：
     * 查询条件包括：用户名、创建起止时间,创建结束时间、是否锁定（1：是；2：否）、排序（创建时间、最后登录时间）
     * @param page 页码
     * @param limit 显示数据条数
     * @param loginname 用户名
     * @param starttime 创建起止时间
     * @param endtime 创建结束时间
     * @param islockout 是否锁定
     * @param sort 排序
     * @return 返回数据
     */
    @GetMapping(value ="/selectUsersCondition",name = "条件检索")
    public Page selectUsersCondition(String page,String limit,String loginname,String starttime,String endtime,String islockout,String sort){

        Integer apage= Integer.valueOf(page);
        Integer alimit= Integer.valueOf(limit);
        Page pages=usersService.selectUsersCondition(apage,alimit,loginname,starttime,endtime,islockout,sort);
        return pages;
    }

    /**
     *创建用户信息：
     * 字段包括：登录名、密码、邮箱、手机号码（注：用户登录名不能相同）
     * @param loginname 登录名
     * @param password 密码
     * @param protectemail 邮箱
     * @param protectmtel 手机号码
     * @return 返回数据
     */
    @GetMapping(value ="/insertUsers",name = "用户")
    public Page insertUsers(String loginname,String password,String protectemail,String protectmtel){
        Page pages=new Page();
        List<Users> la=usersService.selectUsersLoginname(loginname);
        if(la!=null && la.size()>0){
            pages.setCode(101);
            pages.setMsg("用户名已存在");
            return pages;
        }
        UUID uuid=UUID.randomUUID();
        Users users=new Users();
        users.setId(String.valueOf(uuid));
        users.setLoginname(loginname);
        users.setPassword(password);
        users.setProtectemail(protectemail);
        users.setProtectmtel(protectmtel);
        Integer n=usersService.insertUsers(users);
        if(n>0){
            pages.setCode(100);
            pages.setMsg("添加成功");
            return pages;
        }else{
            pages.setCode(101);
            pages.setMsg("添加失败");
            return pages;
        }
    }

    /**
     * 删除用户信息
     * @param loginname 登录名
     * @return 返回数据
     */
    @GetMapping(value ="/deleteUsersLoginname",name = "删除用户")
    public Page deleteUsersLoginname(String loginname){
        Page pages=new Page();

        Integer n=usersService.deleteUsersLoginname(loginname);
        if(n>0){
            pages.setCode(100);
            pages.setMsg("删除成功");
            return pages;
        }else{
            pages.setCode(101);
            pages.setMsg("删除失败");
            return pages;
        }
    }

    /**
     * 编辑用户信息：编辑页显示字段：登录名（只能显示不能编辑）、邮箱、手机号码
     */
    /**
     * 编辑用户信息：
     * 编辑页显示字段：登录名（只能显示不能编辑）、邮箱、手机号码
     * @param loginname 登录名
     * @param protectemail 邮箱
     * @param protectmtel 手机号码
     * @return 返回数据
     */
    @GetMapping(value ="/updateUsers",name = "编辑用户信息")
    public Page updateUsers(String loginname, String protectemail, String protectmtel){
        Page pages=new Page();

        Integer n=usersService.updateUsers(loginname,protectemail,protectmtel);
        if(n>0){
            pages.setCode(100);
            pages.setMsg("编辑成功");
            return pages;
        }else{
            pages.setCode(101);
            pages.setMsg("编辑失败");
            return pages;
        }
    }
}
