package com.spring.view;
import com.spring.annotation.Annotation;
import com.spring.page.Page;
import com.spring.page.ToPage;
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

    @Autowired
    ToPage toPage;

    /**
     * 查询所有的角色，并返回
     * @param page
     * @param limit
     * @return
     */
    @Annotation(desc = "进行查询角色的权限")
    @GetMapping(value = "selectRoles",name = "查询角色")
    public Page selectRoles(Integer page,Integer limit){
        return rolesService.selectRoles(page,limit);
    }

    /**
     * 创建角色，返回一个布尔值
     * @param roles
     * @return
     */
    @Annotation(desc = "进行创建角色的权限")
    @GetMapping(value = "insertRoles", name = "创建角色")
    public boolean insertRoles(String name,String int0,String string0){
        System.out.println(name+int0+string0);
        Integer i = rolesService.insertRoles(name,int0,string0);
        if (i!=0){
            return true;
        }else {
            return false;
        }

    }
    /**
     * 查询一下里面是否有相同的角色名字
     */
    @Annotation(desc = "进行查询角色的权限")
    @RequestMapping(value = "selectName",name = "查询名字")
    public boolean selectName(String name){
        Roles roles = rolesService.selectName(name);
        if (roles!=null) {
            return false;
        }else {
            return true;
        }
    }
    /**
     * 删除角色
     */
     @Annotation(desc = "进行删除角色的权限")
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
    @Annotation(desc = "进行编辑角色的权限")
    @GetMapping(value = "updateName",name = "编辑角色名称")
    public boolean updateName(String newname,String oldname){
        return rolesService.updateName(newname,oldname);
    }

    @RequestMapping(value = "/getRolesName" ,method = RequestMethod.GET ,name = "查询所有角色名字")
    public Page selectRolesName(Integer page, Integer limit){
        return toPage.toPage(page , limit);
    }
}

