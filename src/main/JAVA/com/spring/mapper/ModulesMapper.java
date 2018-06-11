package com.spring.mapper;

import com.spring.pojo.Modules;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModulesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Modules record);

    int insertSelective(Modules record);

    Modules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Modules record);

    int updateByPrimaryKey(Modules record);

    List<Modules> selectUserModules(@Param("userName") String userName , @Param("password") String password);
    List<Modules> selectModuleByRoleId(Integer role);
    List<Modules> selectModuleByNotRoleId(Integer role);
    Integer deleteRoleModuleByModuleAndRole(@Param("module") Integer module,@Param("role") Integer role);
    Integer insertAdminAppendModule(@Param("module") Integer module);
}