package com.spring.service;

import com.spring.mapper.UsersMapper;
import com.spring.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UsersMapper usersMapper;

    public Users selectUserName(String userName){
        return usersMapper.selectUserName(userName);
    }

    public Integer updateUserPsdWrongTime(String userName,String IsLockout,Integer PsdWrongTime ){
        return usersMapper.updateUserPsdWrongTime(userName,IsLockout,PsdWrongTime);
    }
}
