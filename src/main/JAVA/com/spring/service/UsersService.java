package com.spring.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.annotation.Annotation;
import com.spring.mapper.UsersMapper;
import com.spring.page.Page;
import com.spring.pojo.Users;
import com.spring.util.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UsersService {

    @Autowired
    UsersMapper mapper;

    @Annotation(desc ="进行条件检索")
    public Page selectUsersCondition(Integer page,Integer limit,String loginname, String starttime, String endtime, String islockout, String sort){

        if(loginname.equals("null")){
            loginname=null;
        }
        if(starttime==null){
            starttime=null;
        }
        if(starttime.equals("null")){
            starttime=null;
        }
        if(endtime.equals("null")){
            endtime=null;
        }
        if(islockout.equals("null")){
            islockout=null;
        }
        String asort ="";
        if(sort.equals("null")){
            asort=null;
        }else if(sort.equals("创建时间")){
            //创建时间
            asort="CreateTime";
        }else if(sort.equals("最后登录时间")){
            //最后登录时间
            asort="LastLoginTime";
        }

        List<Users> l=null;
        PageHelper.startPage(page,limit);
        PageInfo pageInfo=new PageInfo(mapper.selectUsersCondition(loginname,starttime,endtime,islockout,asort));

        Page pages=new Page();
        pages.setCode(100);
        pages.setMsg("查询成功");
        pages.setCount(pageInfo.getTotal());
        pages.setData(pageInfo.getList());
        return pages;
    }

    @Annotation(desc ="进行创建用户信息")
    public List<Users> selectUsersLoginname(String loginname){
        List<Users> l=null;
        l=mapper.selectUsersLoginname(loginname);
        return l;
    }

    @Annotation(desc ="进行创建用户信息")
    public Integer insertUsers(Users users){
        Integer n=0;
        n=mapper.insertUsers(users);
        return n;
    }

    @Annotation(desc ="进行删除用户")
    public Integer deleteUsersLoginname(String loginname){
        Integer n=0;
        List<Users> l=selectUsersLoginname(loginname);
       n=mapper.deleteUserRolesId(l.get(0).getId());
        n=mapper.deleteUsersLoginname(loginname);
        return n;
    }

    @Annotation(desc ="进行编辑用户信息")
    public Integer updateUsers(String loginname,String protectemail,String protectmtel){
        Integer n=0;
        n=mapper.updateUsers(loginname,protectemail,protectmtel);
        return n;
    }

    @Annotation(desc ="进行重置密码")
    public Integer updateUsersPassword(String loginname){
        Integer n=0;
        PasswordEncoder passwordEncoder=new PasswordEncoder("spring","md5");
        String Password=passwordEncoder.encode("123",5);
        n=mapper.updateUsersPassword(loginname,Password);
        return n;
    }

    @Annotation(desc ="进行锁定用户")
    public Integer lockingUsers(String loginname){
        Integer n=0;
        String locking="是";
        n=mapper.IsLockoutUsers(loginname,locking);
        return n;
    }

    @Annotation(desc ="进行解锁用户")
    public Integer unlockingUsers(String loginname){
        Integer n=0;
        String locking="否";
        n=mapper.IsLockoutUsers(loginname,locking);
        return n;
    }

    @Annotation(desc ="进行查询所有角色")
    public List<String> selectRoles(){
        List<String> l=null;
        l=mapper.selectRoles();
        return l;
    }

    @Annotation(desc ="进行进行查询用户所有角色")
    public List<String> selectUserRoles(String loginname){
        List<String> l=null;
        l=mapper.selectUserRoles(loginname);
        return l;
    }

    @Annotation(desc ="进行添加用户角色")
    public Integer insertUserRole(String loginname,String rolename){
        Integer n=0;
        UUID uuid=UUID.randomUUID();
        String id= String.valueOf(uuid);
        n=mapper.insertUserRole(id,loginname,rolename);
        return n;
    }

    @Annotation(desc ="进行删除用户已有角色")
    public Integer deleteUserRole(String loginname,String rolename){
        Integer n=0;
        n=mapper.deleteUserRole(loginname,rolename);
        return n;
    }

    public Page selectAllStudent(Integer page, Integer limit){
        PageHelper.startPage(page , limit);
        PageInfo pi = new PageInfo(mapper.selectAllUser());
        return new Page(pi , 0);
    }

}
