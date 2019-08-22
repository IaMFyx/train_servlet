package com.ucar.training.service;

import com.ucar.training.entity.TRole;

import java.util.ArrayList;

public interface RoleService {
    /**
     *
     * @return
     */
    ArrayList<TRole> getAllRole();

    /**
     *
     * @param roleID
     */
    void delRole(int roleID);

    /**
     *
     * @param roleName
     */
    void addRole(String roleName);

    /**
     *
     * @param roleID
     * @param menuID
     */
    void addRoleMenu(int roleID,int menuID);

    /**
     *
     * @param roleName
     * @return
     */
    int getRoleIDByName(String roleName);

    /**
     *
     * @param roleID
     * @return
     */
    TRole getRoleByID(int roleID);
}
