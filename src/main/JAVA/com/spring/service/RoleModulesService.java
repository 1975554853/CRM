package com.spring.service;

import com.spring.mapper.ModulesMapper;
import com.spring.mapper.RolemodulesMapper;
import com.spring.mapper.RolesMapper;
import com.spring.pojo.Modules;
import com.spring.pojo.Rolemodules;
import com.spring.pojo.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleModulesService {

    @Autowired
    RolemodulesMapper rolemodulesMapper;

    @Autowired
    RolesMapper rolesMapper;

    @Autowired
    ModulesMapper modulesMapper;

    public Integer insertRolemodules(String[] modval){
        List<String> moduleName = new ArrayList<>();
        int len = modval.length;
        for(int a = 0;a<len-1;a++){
            moduleName.add(modval[a]);
        }
        String roleName = modval[len-1];
        System.out.println(moduleName+"----"+roleName);

        Roles ro = rolesMapper.selectName(roleName);
        String roleId = rolesMapper.selectName(roleName).getId();

        int count = 0;
        for (String temp : moduleName){
            Modules modules = modulesMapper.selectByName(temp);
            Integer moduleId = modules.getId();
            Integer parentId = modules.getParentid();
            Rolemodules rolemodules = rolemodulesMapper.selectRoleModule(moduleId , roleId);

            System.out.println("---------"+rolemodules);

            if (rolemodules != null){
                continue;
            }
           count += rolemodulesMapper.insertRolemodules(moduleId , roleId);
           count += rolemodulesMapper.insertRolemodulesParent(parentId , roleId);
        }
        System.out.println(">>>>>>>"+count);
        return count;
    }

}
