package com.ucar.training.service.impl;

import com.ucar.training.dao.imp.MenuDaoImp;
import com.ucar.training.entity.TMenu;
import com.ucar.training.service.MenuService;

import java.util.ArrayList;

public class MenuServiceImp implements MenuService {
    private static MenuDaoImp menuDaoImp=new MenuDaoImp();
    @Override
    public void addMenu(TMenu menu) {
        menuDaoImp.insertMenu(menu);
    }

    @Override
    public void delMenu(int menuID) {
        menuDaoImp.delMenu(menuID);
    }

    @Override
    public ArrayList<TMenu> getMenus() {
        return menuDaoImp.selectAllMenu();
    }

    @Override
    public TMenu getMenuByID(int menuID) {
        return menuDaoImp.selectMenu(menuID);
    }

    @Override
    public void modifyMenu(TMenu menu) {
        menuDaoImp.updateMenu(menu);
    }
}
