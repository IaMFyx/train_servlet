package com.ucar.training.dao;

import com.ucar.training.entity.TRole;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Map;

public interface RoleDao {
    /**
     *
     * @return
     */
    ArrayList<TRole> selectAllRole();

    /**
     *
     * @param roleID
     */
    void delRole(int roleID);

    /**
     *
     * @param roleName
     */
    void insertRole(String roleName);

    /**
     *
     * @param map
     */
    void insertRoleMenu(Map map);

    /**
     *
     * @param roleName
     * @return
     */
    int selectRoleIDByName(String roleName);

    /**
     *
     * @param roleID
     * @return
     */
    TRole selectRoleByID(int roleID);
}
