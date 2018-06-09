package com.spring.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.page.Page;
import com.spring.service.PermissionServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/per" , name = "权限管理")
public class PermissionControl {

    @Autowired
    private PermissionServive permissionServive;

    /**
     * 查询所有权限
     * @param page 页码
     * @param limit 每页数据
     * @return 返回数据
     */
    @GetMapping(value = "selectPermission",name = "查询所有权限")
    public Page selectPermission(String page,String limit){
        Integer pages= Integer.valueOf(page);
        Integer limits= Integer.valueOf(limit);
        PageHelper.startPage(pages,limits);
        PageInfo pageInfo=new PageInfo(permissionServive.selectPermissionAll());

        Page pagea=new Page();
        pagea.setCode(100);
        pagea.setMsg("查询成功");
        pagea.setCount(pageInfo.getTotal());
        pagea.setData(pageInfo.getList());
        return pagea;
    }

    /**
     * 查询角色是否拥有权限
     * @param roleid 角色id
     * @param page 页码
     * @param limit 数据数
     * @return 返回数据
     */
    @GetMapping(value = "selectRolePermission",name = "查询角色是否拥有权限")
    public Page selectRolePermission(String roleid,String page,String limit){

        Integer pages= Integer.valueOf(page);
        Integer limits= Integer.valueOf(limit);
        PageHelper.startPage(pages,limits);
        PageInfo pageInfo=new PageInfo(permissionServive.selectRolePermission(roleid));

        Page pagea=new Page();
        pagea.setCode(0);
        pagea.setMsg("查询成功");
        pagea.setCount(pageInfo.getTotal());
        pagea.setData(pageInfo.getList());
        return pagea;
    }

    /**
     * 角色权限添加
     * @param roleid 角色id
     * @param permissionid 权限id
     * @return  返回数据
     */
    @GetMapping(value = "insertRolePermission",name = "角色权限添加")
    public Page insertRolePermission(String roleid,String permissionid){
        Page pages=new Page();
        String[] permissionids=permissionid.split(",");
        Integer n=0;
        for(int i=0;i<permissionids.length;i++) {
            n = permissionServive.insertRolePermission(roleid, permissionids[i]);
        }

        if(n>0){
            pages.setCode(100);
            pages.setMsg("角色权限添加成功");
            return pages;
        }else{
            pages.setCode(101);
            pages.setMsg("角色权限添加失败");
            return pages;
        }
    }

    /**
     * 角色权限删除
     * @param roleid 角色id
     * @param permissionid 权限id
     * @return 返回数据
     */
    @GetMapping(value = "deleteRolePermission",name = "角色权限删除")
    public Page deleteRolePermission(String roleid,String permissionid){
        Page pages=new Page();
        Integer n = permissionServive.deleteRolePermission(roleid, permissionid);

        if(n>0){
            pages.setCode(100);
            pages.setMsg("角色权限删除成功");
            return pages;
        }else{
            pages.setCode(101);
            pages.setMsg("角色权限删除失败");
            return pages;
        }
    }

}
