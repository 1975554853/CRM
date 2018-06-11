package com.spring.service;

import com.spring.mapper.ModulesMapper;
import com.spring.mapper.RolesMapper;
import com.spring.mapper.UserrolesMapper;
import com.spring.mapper.UsersMapper;
import com.spring.page.Page;
import com.spring.pojo.Modules;
import com.spring.pojo.Userroles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulesService {

    @Autowired
    ModulesMapper modulesMapper;

    @Autowired
    UsersMapper usersMapper;
    @Autowired
    UserrolesMapper userrolesMapper;

    /**
     * 通过角色名查询模块
     * @param roleName 角色名
     * @return 模块
     */
    public List<Modules> selectRolesModules(String roleName){
        return modulesMapper.selectRolesModules(roleName);
    }

    public List<Modules> selectChildModuleById(Integer moduleId) {
        return modulesMapper.selectChildModuleById(moduleId);
    }

    public Page insertRoles(String selectUser, String[] namesId){
        int n = 0;
        for (int i=0 ;i<namesId.length;i++){
            Userroles userroles = userrolesMapper.selectOne(selectUser , namesId[i]);
//            System.out.println("查看userroles---"+userroles);
            if (userroles != null){
                continue;
            }
            n +=modulesMapper.insertRole(selectUser , namesId[i]);
        }
        if (n == 0){
            return new Page(4 , "添加角色失败或已存在");
        }
        return new Page(6 , "添加角色成功"+n);
    }
}
