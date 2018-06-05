package com.spring.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.mapper.RolesMapper;
import com.spring.page.Page;
import com.spring.pojo.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class RolesService {
    @Autowired
    RolesMapper rolesMapper;
    public Page selectRoles(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo pageInfo = new PageInfo(rolesMapper.selectRoles());
        Page p = new Page(0,pageInfo.getTotal(),pageInfo.getList());
       return p;

    }

    public Integer insertRoles(List<Roles> roles) {
        for (Roles r:roles) {
            rolesMapper.insert(r);
        }
       return 0;
    }
}
