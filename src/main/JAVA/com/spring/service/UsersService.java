package com.spring.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.mapper.UsersMapper;
import com.spring.page.Page;
import com.spring.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersMapper mapper;

    public Page selectUsersCondition(Integer page,Integer limit,String loginname, String starttime, String endtime, String islockout, String sort){
        String asort ="";
        if(sort==null){
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

    public List<Users> selectUsersLoginname(String loginname){
        List<Users> l=null;
        l=mapper.selectUsersLoginname(loginname);
        return l;
    }

    public Integer insertUsers(Users users){
        Integer n=0;
        n=mapper.insertUsers(users);
        return n;
    }

    public Integer deleteUsersLoginname(String loginname){
        Integer n=0;
        n=mapper.deleteUsersLoginname(loginname);
        return n;
    }

    public Integer updateUsers(String loginname,String protectemail,String protectmtel){
        Integer n=0;
        n=mapper.updateUsers(loginname,protectemail,protectmtel);
        return n;
    }

}
