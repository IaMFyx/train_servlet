package com.ucar.training.service;

import com.ucar.training.entity.TMenu;

import java.util.ArrayList;

public interface MenuService {
    /**
     *
     * @param menu
     */
    void addMenu(TMenu menu);

    /**
     *
     * @param menuID
     */
    void delMenu(int menuID);

    /**
     *
     * @return
     */
    ArrayList<TMenu> getMenus();

    /**
     *
     * @param menuID
     * @return
     */
    TMenu getMenuByID(int menuID);
    /**
     *
     * @param menu
     */
    void modifyMenu(TMenu menu);
}
