package com.spring.service;

import com.spring.mapper.ModulesMapper;
import com.spring.pojo.Modules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ModuleService {
    @Autowired
    ModulesMapper mapper;
    public List<Modules> selectModuleByRoleId(String role){
        return  mapper.selectModuleByRoleId(role);
    }
    public List<Modules> selectModuleByNotRoleId(String role){
        return  mapper.selectModuleByNotRoleId(role);
    }
    public boolean insertRoleModule(Integer role,Integer[] module){
        UUID uuid = UUID.randomUUID();
        Integer n = 0;
        for (Integer i :module){
            mapper.insertRoleModule(String.valueOf(uuid),role,i);
            n++;
        }
        if (n==module.length) {
            return  true;
        }
        return false;
    }
    public boolean deleteRoleModuleByModuleAndRole(Integer role,Integer[] module){
        Integer n = 0;
        for(Integer i :module){
          mapper.deleteRoleModuleByModuleAndRole(i,role);
          n++;
        }
        if (n==module.length) {
            return  true;
        }else {
            return false;
        }
    }
}
