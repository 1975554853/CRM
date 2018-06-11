package com.spring.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 进行分页
 */
@Component
public class ToPage {

    @Autowired
    RolesService rolesService;

    public Page toPage(Integer page, Integer limit){
        PageHelper.startPage(page , limit);
        PageInfo pi = new PageInfo(rolesService.selectRolesName());
        Page pg = new Page(pi , 0);
        return pg;
    }

}
