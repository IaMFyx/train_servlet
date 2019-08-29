package com.ucar.training.service.impl;

import com.ucar.training.dao.MenuDao;
import com.ucar.training.entity.TMenu;
import com.ucar.training.service.MenuService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;

@Service("menuService")
public class MenuServiceImp implements MenuService {
    @Resource(name = "menuDao")
    private MenuDao menuDaoImp;
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
