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

        for (Permissiontb p:permissiontbs){
            Integer isHave = 2;
            for(Permissiontb rp:rolepermissiontbs){
                if(rp.getPermissionvalue().equals(p.getPermissionvalue())){
                    isHave=3;
                    break;
                }
            }
            p.setIsHava(isHave);
        }
        return permissiontbs;
    }
//分配

    public Integer insertRolePermission(String roleid,String permissionid){
        Integer n=0;
        n=mapper.insertRolePermission(roleid,permissionid);
        return n;
    }

    public Integer deleteRolePermission(String roleid,String permissionid){
        Integer n=0;
        n=mapper.deleteRolePermission(roleid,permissionid);
        return n;
    }


}
