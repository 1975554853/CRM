package com.spring.mapper;

import com.spring.pojo.Permissiontb;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissiontbMapper {
    int deleteByPrimaryKey(Integer permissionid);

    int insert(Permissiontb record);

    int insertSelective(Permissiontb record);

    Permissiontb selectByPrimaryKey(Integer permissionid);

    int updateByPrimaryKeySelective(Permissiontb record);

    int updateByPrimaryKey(Permissiontb record);

    List<String> selectAll();

    Integer batchInsert(List<Permissiontb> list);

    List<String> queryPermissionByUserID(Integer userid);

    List<Permissiontb> selectPermissionAll();

    List<Permissiontb> selectRolePermission(String roleid);

    Integer insertRolePermission(@Param("roleid") String roleid,@Param("permissionid") String permissionid);

    Integer deleteRolePermission(@Param("roleid") String roleid,@Param("permissionid") String permissionid);



}