package com.spring.service;

import com.spring.mapper.PermissiontbMapper;
import com.spring.pojo.Permissiontb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServive {

    @Autowired
    PermissiontbMapper mapper;

    public List<Permissiontb> selectPermissionAll(){
        List<Permissiontb> l=null;
        l=mapper.selectPermissionAll();
        return l;
    }
}
