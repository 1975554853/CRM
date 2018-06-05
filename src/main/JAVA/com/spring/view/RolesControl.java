package com.spring.view;

import com.spring.page.Page;
import com.spring.pojo.Roles;
import com.spring.service.RolesService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value ="jdgl",name = "角色管理系统")
@RestController
@CrossOrigin
public class RolesControl {

    @Autowired
    RolesService rolesService;

    @GetMapping(value = "selectRoles",name = "查询角色")
    public Page selectRoles(Integer page,Integer limit){
        return rolesService.selectRoles(page,limit);

    }
    @GetMapping(value = "insertRoles", name = "创建角色")
    public boolean insertRoles(@RequestParam("Roles") List<Roles> Roles){
        Integer i = rolesService.insertRoles(Roles);
        if (i!=0){
            return true;
        }else {
            return false;
        }
    }
}
