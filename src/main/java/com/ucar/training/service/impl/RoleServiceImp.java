package com.ucar.training.service.impl;

import com.ucar.training.dao.imp.RoleDaoImp;
import com.ucar.training.entity.TRole;
import com.ucar.training.service.RoleService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RoleServiceImp implements RoleService {
    private static RoleDaoImp roleDaoImp=new RoleDaoImp();
    @Override
    public ArrayList<TRole> getAllRole() {
        return roleDaoImp.selectAllRole();
    }

    @Override
    public void delRole(int roleID) {
        roleDaoImp.delRole(roleID);
    }

    @Override
    public void addRoleMenu(int roleID, int menuID) {
        Map map=new HashMap();
        map.put("roleID",roleID);
        map.put("menuID",menuID);
        roleDaoImp.insertRoleMenu(map);
    }

    @Override
    public TRole getRoleByID(int roleID) {
        return roleDaoImp.selectRoleByID(roleID);
    }

    @Override
    public int getRoleIDByName(String roleName) {
        return roleDaoImp.selectRoleIDByName(roleName);
    }

    @Override
    public void addRole(String roleName) {
        roleDaoImp.insertRole(roleName);
    }
}
