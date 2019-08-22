package com.ucar.training.entity;


import java.util.List;

public class TRole {

    private int rid;
    private String roleName;
    private List<TMenu> menusList;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<TMenu> getMenusList() {
        return menusList;
    }

    public void setMenusList(List<TMenu> menusList) {
        this.menusList = menusList;
    }
}
