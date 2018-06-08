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
public class PermissionContril {

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

}
