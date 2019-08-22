package com.ucar.training.dao.imp;

import com.ucar.training.dao.MenuDao;
import com.ucar.training.entity.TMenu;
import com.ucar.training.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class MenuDaoImp implements MenuDao {
    private static DBUtil dbUtil=new DBUtil();
    @Override
    public ArrayList<TMenu> selectAllMenu() {
        SqlSession sqlSession=null;
        ArrayList<TMenu> menus=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            menus=(ArrayList)sqlSession.selectList("selectAllMenu");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(sqlSession);
        }
        return menus;
    }

    @Override
    public TMenu selectMenu(int menuID) {
        SqlSession sqlSession=null;
        TMenu menu=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            menu=sqlSession.selectOne("selectMenu",menuID);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(sqlSession);
        }
        return menu;
    }

    @Override
    public void insertMenu(TMenu menu) {
        SqlSession sqlSession=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            sqlSession.insert("insertMenu",menu);
            sqlSession.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(sqlSession);
        }
    }

    @Override
    public void delMenu(int menuID) {
        SqlSession sqlSession=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            sqlSession.delete("delMenu",menuID);
            sqlSession.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(sqlSession);
        }
    }

    @Override
    public void updateMenu(TMenu menu) {
        SqlSession sqlSession=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            sqlSession.update("updateMenu",menu);
            sqlSession.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(sqlSession);
        }
    }
}
