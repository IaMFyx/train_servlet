package com.ucar.training.dao.imp;

import com.ucar.training.dao.MessageDao;
import com.ucar.training.entity.UserMessage;
import com.ucar.training.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.ArrayList;

public class MessageDaoImp implements MessageDao {
    private static DBUtil dbUtil=new DBUtil();
    @Override
    public void addMessage(UserMessage userMessage) {
        SqlSession sqlSession=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            sqlSession.insert("addMessage",userMessage);
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
    public void delMessage(int messageID) {
        SqlSession sqlSession=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            sqlSession.delete("delMessage",messageID);
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
    public ArrayList<UserMessage> selectAllMessages() {
        SqlSession sqlSession=null;
        ArrayList<UserMessage> messages=null;
        try {
            sqlSession=dbUtil.getSqlSession();
            messages=(ArrayList)sqlSession.selectList("selectAllMessages");
            sqlSession.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(sqlSession);
        }
        return messages;
    }
}
