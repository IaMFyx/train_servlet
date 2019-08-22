package com.ucar.training.dao.imp;

import com.ucar.training.dao.RoleDao;
import com.ucar.training.entity.TRole;
import com.ucar.training.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.ArrayList;
import java.util.Map;

public class RoleDaoImp implements RoleDao {
    private static DBUtil dbUtil=new DBUtil();
    @Override
    public ArrayList<TRole> selectAllRole() {
        SqlSession sqlSession=null;
        ArrayList<TRole> roles=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            roles=(ArrayList)sqlSession.selectList("selectAllRole");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(sqlSession);
        }
        return roles;
    }

    @Override
    public void delRole(int roleID) {
        SqlSession sqlSession=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            sqlSession.delete("delRole",roleID);
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
    public TRole selectRoleByID(int roleID) {
        SqlSession sqlSession=null;
        TRole role=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            role=sqlSession.selectOne("selectRoleByID",roleID);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(sqlSession);
        }
        return role;
    }

    @Override
    public int selectRoleIDByName(String roleName) {
        SqlSession sqlSession=null;
        int roleID=0;
        try {
            sqlSession=dbUtil.getSqlSession();
            roleID=sqlSession.selectOne("selectRoleIDByName",roleName);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(sqlSession);
        }
        return roleID;
    }

    @Override
    public void insertRole(String roleName) {
        SqlSession sqlSession=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            sqlSession.insert("insertRole",roleName);
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
    public void insertRoleMenu(Map map) {
        SqlSession sqlSession=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            sqlSession.insert("insertRoleMenu",map);
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
