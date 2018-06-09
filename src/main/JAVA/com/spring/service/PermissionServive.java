package com.spring.service;

import com.spring.mapper.PermissiontbMapper;
import com.spring.pojo.Permissiontb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServive {

    @Autowired
    PermissiontbMapper mapper;

    public List<Permissiontb> selectPermissionAll(){
        List<Permissiontb> l=null;
        l=mapper.selectPermissionAll();
        return l;
    }

    public List<Permissiontb> selectRolePermission(String roleid){
        List<Permissiontb> permissiontbs=mapper.selectPermissionAll();
        List<Permissiontb> rolepermissiontbs=mapper.selectRolePermission(roleid);

        for(Permissiontb rp:rolepermissiontbs){
            for (Permissiontb p:permissiontbs){
                if(rp.getPermissionvalue().equals(p.getPermissionvalue())){
                    p.setIsHava("已拥有");
                }else{
                    p.setIsHava("未拥有");
                }
            }
        }
        return permissiontbs;
    }
}
