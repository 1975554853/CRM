package com.spring.service;

import com.spring.mapper.UsersMapper;
import com.spring.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersMapper mapper;

    public List<Users> selectUsersCondition(String loginname,String starttime,String endtime,String islockout,String sort){

       return mapper.selectUsersCondition(loginname,starttime,endtime,islockout,sort);
    }

}
