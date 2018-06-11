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
    public List selectModuleByRoleId(Integer role){
        return  moduleService.selectModuleByRoleId(role);
    }
    @GetMapping(value = "selectModuleByNotRoleId",name = "查找不包含的模块")
    public List selectModuleByNotRoleId(Integer role){
        return  moduleService.selectModuleByNotRoleId(role);
    }
    @GetMapping(value = "insertAdminAppendModule",name = "插入模块")
    public Integer insertAdminAppendModule(Integer module){
        return  moduleService.insertAdminAppendModule(module);
    }
    @GetMapping(value = "deleteRoleModuleByModuleAndRole",name = "删除模块")
    public Integer deleteRoleModuleByModuleAndRole(Integer role,Integer module){
        return  moduleService.deleteRoleModuleByModuleAndRole(role,module);
    }
}
