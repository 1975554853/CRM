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

    Integer updateUserPsdWrongTime(@Param("userName")String userName,@Param("IsLockout") String IsLockout,@Param("PsdWrongTime")Integer PsdWrongTime);

    List<Users> selectUsersCondition(@Param("loginname") String loginname,@Param("starttime") String starttime,
                                     @Param("endtime") String endtime,@Param("islockout") String islockout,
                                     @Param("sort") String sort);

    List<Users> selectUsersLoginname(String loginname);

    List<Users> selectAllUser();

    Integer insertUsers(Users users);

    Integer deleteUserRolesId(String id);
    Integer deleteUsersLoginname(String loginname);

    Integer updateUsers(@Param("loginname") String loginname,@Param("protectemail")String protectemail,@Param("protectmtel")String protectmtel);

    Integer updateUsersPassword(String loginname);

    Integer IsLockoutUsers(@Param("loginname") String loginname,@Param("IsLockout")String IsLockout);

    List<String> selectRoles();
    List<String> selectUserRoles(@Param("loginname")String loginname);
    Integer insertUserRole(@Param("id")String id,@Param("loginname") String loginname,@Param("rolename")String rolename);
    Integer deleteUserRole(@Param("loginname") String loginname,@Param("rolename")String rolename);
}