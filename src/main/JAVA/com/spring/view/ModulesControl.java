package com.spring.view;

import com.spring.page.Page;
import com.spring.pojo.Modules;
import com.spring.pojo.Roles;
import com.spring.service.ModulesService;
import com.spring.service.RoleModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/modules" , name = "模块")
public class ModulesControl {

    @Autowired
    ModulesService modulesService;

    @Autowired
    HttpSession session;

    @Autowired
    RoleModulesService roleModulesService;

    @RequestMapping(value = "/setRoleModule" , method = RequestMethod.GET , name = "设置用户名")
    public void setRoleModule(String name){
        session.setAttribute("roleName" , name);
//        System.out.println("setSession");
    }

    @RequestMapping(value = "/getRoleModule" , method = RequestMethod.GET , name = "得到角色父模块")
    public List<Modules> getRoleModule(){
        String name = (String) session.getAttribute("roleName");
//        System.out.println("session>>>>"+name);
        return modulesService.selectRolesModules(name);
    }

    @RequestMapping(value = "/getChileModule" , method = RequestMethod.POST , name = "得到子模块")
    public List<Modules> getChileModule(Integer moduleId){
        return modulesService.selectChildModuleById(moduleId);
    }

    @RequestMapping(value = "/insertModules" , method = RequestMethod.POST, name = "为角色添加模块")
    public Page insertModules(@RequestParam(value="modval[]")String[] modval){
        System.out.println(Arrays.toString(modval));
        Integer count = roleModulesService.insertRolemodules(modval);
        if(count == 0){
            return new Page(4 , "添加失败或已存在");
        }
        return new Page(6 , "添加成功");
    }

    @RequestMapping(value = "/insertRoles" , method = RequestMethod.POST , name = "为用户添加角色")
    public Page insertRoles(String selectUser,@RequestParam("namesId[]")String[] namesId){
        System.out.println("----"+Arrays.toString(namesId));
        Page p = modulesService.insertRoles(selectUser , namesId);
        return p;
    }
}
