package com.spring.mapper;

import com.spring.pojo.Userroles;
import org.apache.ibatis.annotations.Param;

public interface UserrolesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Userroles record);

    int insertSelective(Userroles record);

    Userroles selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Userroles record);

    int updateByPrimaryKey(Userroles record);

    Userroles selectOne(@Param("userId") String userId,@Param("roleId") String roleId);
}