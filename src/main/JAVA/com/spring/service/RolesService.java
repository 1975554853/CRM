package com.spring.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.mapper.RolesMapper;
import com.spring.page.Page;
import com.spring.pojo.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.UUID;
@Service
public class RolesService {
    @Autowired
    RolesMapper rolesMapper;
    public Page selectRoles(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        PageInfo pageInfo = new PageInfo(rolesMapper.selectRoles());
        Page p = new Page(0,pageInfo.getTotal(),pageInfo.getList());
       return p;
    }
    public Integer insertRoles(String name,String int0,String string0) {
            UUID uuid = UUID.randomUUID();
            Roles roles = new Roles();
            roles.setId(String.valueOf(uuid));
            roles.setName(name);
            roles.setInt0(Integer.parseInt(int0));
            roles.setString0(string0);
           Integer i = rolesMapper.insert(roles);
       return i;
    }
    public Integer deleteRole(String name) {
        Roles roles = selectName(name);
        String id = roles.getId();
        rolesMapper.deleteUserRole(id);
        rolesMapper.deleteRoleModule(id);
        rolesMapper.deleteRolePermission(id);
        return rolesMapper.deleteRole(id);
    }
    public Roles selectName(String name) {
        Roles roles = rolesMapper.selectName(name);
           return  roles;
    }

    public boolean updateName(String newname,String oldname){
        Integer i = rolesMapper.updateName(newname,oldname);
        if (i==0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 查询所有角色名
     * @return 所有角色名
     */
    public List<Roles> selectRolesName(){
        return rolesMapper.selectRolesName();
    }

}
