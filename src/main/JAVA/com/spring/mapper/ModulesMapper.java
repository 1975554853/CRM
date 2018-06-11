package com.spring.mapper;

import com.spring.pojo.Modules;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModulesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Modules record);

    int insertRole(@Param("selectUserId") String selectUserId ,@Param("nameId") String nameId);

    int insertSelective(Modules record);

    Modules selectByPrimaryKey(Integer id);

    Modules selectByName(String name);

    int updateByPrimaryKeySelective(Modules record);

    int updateByPrimaryKey(Modules record);

    List<Modules> selectRolesModules(@Param("roleName") String roleName);

    List<Modules> selectUserModules(@Param("userName") String userName , @Param("password") String password);
    List<Modules> selectModuleByRoleId(String role);
    List<Modules> selectModuleByNotRoleId(String role);
    Integer deleteRoleModuleByModuleAndRole(@Param("module") Integer module,@Param("role") Integer role);
    Integer insertAdminAppendModule(@Param("module") Integer module);

    List<Modules> selectChildModuleById(Integer moduleId);
}