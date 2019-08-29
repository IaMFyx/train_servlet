package com.ucar.training.dao;

import com.ucar.training.entity.TMenu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("menuDao")
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
