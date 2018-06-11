package com.spring.view;
import com.spring.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "module",name = "模块系统")
public class ModuleControl {
    @Autowired
    ModuleService moduleService;

    @GetMapping(value = "selectModuleByRoleId",name = "查找包含的模块")
    public List selectModuleByRoleId(String role){
        return  moduleService.selectModuleByRoleId(role);
    }
    @GetMapping(value = "selectModuleByNotRoleId",name = "查找不包含的模块")
    public List selectModuleByNotRoleId(String role){
        return  moduleService.selectModuleByNotRoleId(role);
    }
    @GetMapping(value = "insertRoleModule",name = "插入模块")
    public boolean insertRoleModule(Integer role,Integer[] module){
        return  moduleService.insertRoleModule(role,module);
    }
    @GetMapping(value = "deleteRoleModuleByModuleAndRole",name = "删除模块")
    public boolean deleteRoleModuleByModuleAndRole(Integer role,Integer[] module){
        return  moduleService.deleteRoleModuleByModuleAndRole(role,module);
    }
}
