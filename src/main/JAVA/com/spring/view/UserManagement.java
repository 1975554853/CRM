package com.spring.view;

import com.spring.annotation.Annotation;
import com.spring.page.Page;
import com.spring.pojo.Users;
import com.spring.service.UsersService;
import com.spring.util.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param loginname 查询的用户名
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
     * @param loginname 新用户的登录名
     * @param password 密码
     * @param protectemail 邮箱
     * @param protectmtel 手机号码
     * @return 返回数据
     */
    @GetMapping(value ="/insertUsers",name = "创建用户")
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
        //密码加密
        PasswordEncoder passwordEncoder=new PasswordEncoder("spring","md5");
        String newpassWord=passwordEncoder.encode(password,5);

        users.setPassword(newpassWord);
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
     * @param loginname 删除的用户的登录名
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
     * 编辑用户信息：
     * 编辑页显示字段：登录名（只能显示不能编辑）、邮箱、手机号码
     * @param loginname 编辑的用户的登录名
     * @param protectemail 邮箱
     * @param protectmtel 手机号码
     * @return 返回数据
     */
    @GetMapping(value ="/updateUsers",name = "编辑用户信息")
    public Page updateUsers(String loginname, String protectemail, String protectmtel){
        Page pages=new Page();
        System.out.println(loginname+","+protectmtel);

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

    /**
     * 重置密码：
     * 重置之后的密码为ysd123
     * @param loginname 重置的用户的登录名
     * @return 返回数据
     */
    @Annotation(desc ="进行重置密码")
    @GetMapping(value = "updateUsersPassword",name = "重置密码")
    public Page updateUsersPassword(String loginname){
        Page pages=new Page();

        Integer n=usersService.updateUsersPassword(loginname);
        if(n>0){
            pages.setCode(100);
            pages.setMsg("重置成功");
            return pages;
        }else{
            pages.setCode(101);
            pages.setMsg("重置失败");
            return pages;
        }
    }

    /**
     * 锁定用户：
     * 锁定之后的用户不能进行登录操作
     * @param loginname 锁定的用户的登录名
     * @return 返回数据
     */
    @GetMapping(value = "lockingUsers",name = "锁定用户")
    public Page lockingUsers(String loginname){
        Page pages=new Page();

        Integer n=usersService.lockingUsers(loginname);
        if(n>0){
            pages.setCode(100);
            pages.setMsg("锁定成功");
            return pages;
        }else{
            pages.setCode(101);
            pages.setMsg("锁定失败");
            return pages;
        }
    }

    /**
     *解锁用户：
     * 对已锁定的用户进行解锁操作使其能够进行系统的登录操作
     * @param loginname 解定的用户的登录名
     * @return 返回数据
     */
    @GetMapping(value = "unlockingUsers",name = "解锁用户")
    public Page unlockingUsers(String loginname){
        Page pages=new Page();

        Integer n=usersService.unlockingUsers(loginname);
        if(n>0){
            pages.setCode(100);
            pages.setMsg("解锁成功");
            return pages;
        }else{
            pages.setCode(101);
            pages.setMsg("解锁失败");
            return pages;
        }
    }

    /**
     * 查询所有角色
     * @return 返回数据
     */
    @GetMapping(value ="/selectRoles",name = "查询所有角色")
    public Page selectRoles(){
        Page page=new Page();
        List<String> l=usersService.selectRoles();
        page.setData(l);
        return page;
    }

    /**
     * 查询所查用户所有角色
     * @param loginname  所查用户登录名
     * @return 返回数据
     */
    @GetMapping(value ="/selectUserRoles",name = "查询所查用户所有角色")
    public Page selectUserRoles(String loginname){
        Page page=new Page();
        List<String> l=usersService.selectUserRoles(loginname);
        page.setData(l);
        return page;
    }

    /**
     * 添加所查用户角色
     * @param loginname  所查用户登录名
     * @param rolename  添加的角色名
     * @return 返回数据
     */
    @GetMapping(value ="/insertUserRole",name = "添加所查用户角色")
    public Page insertUserRole(String loginname,String rolename ){
        Page pages=new Page();
        List<String> l=usersService.selectUserRoles(loginname);
        if(l.contains(rolename)){
            pages.setCode(101);
            pages.setMsg("添加用户角色已拥有");
            return pages;
        }
        Integer n=usersService.insertUserRole(loginname,rolename);
        if(n>0){
            pages.setCode(100);
            pages.setMsg("添加用户角色成功");
            return pages;
        }else{
            pages.setCode(101);
            pages.setMsg("添加用户角色失败");
            return pages;
        }
    }

    /**
     * 删除所查用户角色
     * @param loginname 所查用户登录名
     * @param rolename 删除的角色名
     * @return
     */
    @GetMapping(value ="/deleteUserRole",name = "删除所查用户角色")
    public Page deleteUserRole(String loginname,String rolename){
        Page pages=new Page();
        Integer n=usersService.deleteUserRole(loginname,rolename);
        if(n>0){
            pages.setCode(100);
            pages.setMsg("删除用户角色成功");
            return pages;
        }else{
            pages.setCode(101);
            pages.setMsg("删除用户角色失败");
            return pages;
        }
    }

    @RequestMapping(value = "/selectAllUsers" , method = RequestMethod.GET)
    public Page selectAllUsers(Integer page, Integer limit){
        return usersService.selectAllStudent(page , limit);
    }

}
