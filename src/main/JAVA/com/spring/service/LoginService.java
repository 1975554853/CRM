package com.spring.service;

import com.spring.mapper.UsersMapper;
import com.spring.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UsersMapper usersMapper;

    public Users selectOneUser(String userName , String password){
        return usersMapper.selectOneUser(userName , password);
    }
}
