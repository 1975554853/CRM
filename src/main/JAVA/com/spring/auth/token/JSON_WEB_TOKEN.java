package com.spring.auth.token;

import java.util.List;

public class JSON_WEB_TOKEN {
    private Integer id;
    private List<String> roles;
    private List<String> permissions;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JSON_WEB_TOKEN() {
    }

    public JSON_WEB_TOKEN(Integer id, List<String> permissions) {
        this.id = id;
        this.permissions = permissions;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
