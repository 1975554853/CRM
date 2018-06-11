package com.spring.service;

import com.spring.mapper.ModulesMapper;
import com.spring.pojo.Modules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {
    @Autowired
    ModulesMapper mapper;
    public List<Modules> selectModuleByRoleId(Integer role){
        return  mapper.selectModuleByRoleId(role);
    }
    public List<Modules> selectModuleByNotRoleId(Integer role){
        return  mapper.selectModuleByNotRoleId(role);
    }
    public Integer insertAdminAppendModule(Integer module){
        return  mapper.insertAdminAppendModule(module);
    }
    public Integer deleteRoleModuleByModuleAndRole(Integer role,Integer module){
        return  mapper.deleteRoleModuleByModuleAndRole(role,module);
    }
}
