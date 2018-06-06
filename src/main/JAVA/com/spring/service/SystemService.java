package com.spring.service;

import com.spring.annotation.Annotation;
import com.spring.mapper.PermissiontbMapper;
import com.spring.pojo.Permissiontb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemService {
    @Autowired
    PermissiontbMapper permissiontbMapper;

    @Annotation(desc = "查询系统所有权限")
    public List<String> selectAll(){
        return permissiontbMapper.selectAll();
    }

    @Annotation(desc = "插入系统权限"  , isWrite = false)
    public Object insertSystemPermission(List<Permissiontb> permissionList) {
        return permissiontbMapper.batchInsert(permissionList);
    }

    public List<String> queryPermissionByUserID(Integer id){
        return permissiontbMapper.queryPermissionByUserID(id);
    }

}
