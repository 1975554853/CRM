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

    /**
     * 查询所有的角色，并返回
     * @param page
     * @param limit
     * @return
     */
    @GetMapping(value = "selectRoles",name = "查询角色")
    public Page selectRoles(Integer page,Integer limit){
        return rolesService.selectRoles(page,limit);

    }

    /**
     * 创建角色，返回一个布尔值
     * @param roles
     * @return
     */
    @GetMapping(value = "insertRoles", name = "创建角色")
    public boolean insertRoles(Roles roles){
        Integer i = rolesService.insertRoles(roles);
        if (i!=0){
            return true;
        }else {
            return false;
        }
    }
    /**
     * 查询一下里面是否有相同的角色名字
     */
    @RequestMapping(value = "selectName",name = "查询名字")
    public boolean selectName(String name){
        return rolesService.selectName(name);
    }
    /**
     * 删除角色
     */
     @GetMapping(value ="deleteRole",name = "删除角色")
     public boolean deleteRole(String name){
         System.out.println(name);
         Integer i = rolesService.deleteRole(name);
         if (i!=0){
             return true;
         }else {
             return false;
         }
     }
    /**
     * 编辑角色名称
     */
    @GetMapping(value = "updateName",name = "编辑角色名称")
    public boolean updateName(String newname,String oldname){
        return rolesService.updateName(newname,oldname);
    }
}

