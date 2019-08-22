package com.ucar.training.dao;

import com.ucar.training.entity.TMenu;

import java.util.ArrayList;

public interface MenuDao {
    /**
     *
     * @return
     */
    ArrayList<TMenu> selectAllMenu();

    /**
     *
     * @param menuID
     * @return
     */
    TMenu selectMenu(int menuID);

    /**
     *
     * @param menu
     */
    void insertMenu(TMenu menu);

    /**
     *
     * @param menuID
     */
    void delMenu(int menuID);

    /**
     *
     * @param menu
     */
    void updateMenu(TMenu menu);
}
