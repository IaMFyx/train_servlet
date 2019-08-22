package com.ucar.training.dao.imp;

import com.ucar.training.dao.UserDao;
import com.ucar.training.entity.TMenu;
import com.ucar.training.entity.User;
import com.ucar.training.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.ArrayList;

public class UserDaoImp implements UserDao {
    private static DBUtil dbUtil=new DBUtil();
    @Override
    public void addUser(User user) {
        SqlSession sqlSession=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            sqlSession.insert("addUser",user);
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
    public void delUser(String username) {
        SqlSession sqlSession=null;
        try{
            sqlSession=dbUtil.getSqlSession();
            sqlSession.getMapper(UserDao.class).delUser(username);
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
    public User selectUser(String username) {
        SqlSession sqlSession=null;
        User user=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            user=sqlSession.selectOne("selectUser",username);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(sqlSession);
        }
        return user;
    }

    @Override
    public ArrayList<User> selectAllUser() {
        SqlSession sqlSession=null;
        ArrayList<User> users=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            users=(ArrayList)sqlSession.selectList("selectAllUser");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(sqlSession);
        }
        return users;
    }
    @Override
    public void modifyUser(User user){
        SqlSession sqlSession=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            sqlSession.update("modifyUser",user);
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
    public ArrayList<TMenu> selectUserMenu(int role) {
        SqlSession sqlSession=null;
        ArrayList<TMenu> menu=null;
        try{
            sqlSession=dbUtil.getSqlSession();
            menu=(ArrayList)sqlSession.selectList("selectUserMenu",role);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(sqlSession);
        }
        return menu;
    }
}
