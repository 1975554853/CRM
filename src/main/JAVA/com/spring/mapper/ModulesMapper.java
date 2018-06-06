package com.spring.mapper;

import com.spring.pojo.Modules;
import org.apache.ibatis.annotations.Param;

public interface ModulesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Modules record);

    int insertSelective(Modules record);

    Modules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Modules record);

    int updateByPrimaryKey(Modules record);

    Modules selectUserModules(@Param("userName") String userName ,@Param("password") String password);
}