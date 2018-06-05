package com.spring.mapper;

import com.spring.pojo.Roles;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);

    List<Roles> selectRoles();

}