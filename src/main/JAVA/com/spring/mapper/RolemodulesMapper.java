package com.spring.mapper;

import com.spring.pojo.Rolemodules;
import org.apache.ibatis.annotations.Param;


public interface RolemodulesMapper {
    Integer insertRolemodules(@Param("moduleId")Integer moduleId ,@Param("roleId") String roleId);

    Integer insertRolemodulesParent(@Param("parentId")Integer parentId ,@Param("roleId") String roleId);

    Rolemodules selectRoleModule(@Param("moduleId")Integer moduleId ,@Param("roleId") String roleId);
}
