package com.spring.mapper;

import com.spring.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users selectUserName(@Param("userName") String userName);

    Users selectOneUser(@Param("userName") String userName, @Param("password") String password);

    List<Users> selectUsersCondition(String loginname, String starttime, String endtime, String islockout, String sort);

}