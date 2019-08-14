package com.ucar.training.dao;

import com.ucar.training.entity.UserMessage;
import com.ucar.training.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDaoImp implements MessageDao {
    private DBUtil dbUtil=new DBUtil();
    @Override
    public void addMessage(UserMessage userMessage) {
        String sql="INSERT INTO t_message(username,messageTitle,messageContent)VALUES(?,?,?)";
        Connection conn=null;
        PreparedStatement prst=null;
        try {
            conn = dbUtil.getConnection();
            prst = conn.prepareStatement(sql);
            prst.setString(1, userMessage.getUsername());
            prst.setString(2,userMessage.getMessageTitle());
            prst.setString(3,userMessage.getMessageContent());
            prst.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(prst);
            dbUtil.close(conn);
        }
    }

    @Override
    public void delMessage(int messageID) {
        String sql="DELETE FROM t_message WHERE id=?";
        Connection conn=null;
        PreparedStatement prst=null;
        try {
            conn=dbUtil.getConnection();
            prst=conn.prepareStatement(sql);
            prst.setInt(1,messageID);
            prst.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(prst);
            dbUtil.close(conn);
        }
    }

    @Override
    public ArrayList<UserMessage> findAllMessages() {
        String sql="SELECT id,username,messageTitle,messageContent,create_time FROM t_message";
        Connection conn=null;
        PreparedStatement prst=null;
        ResultSet rs=null;
        ArrayList<UserMessage> messages=new ArrayList<>();
        try {
            conn=dbUtil.getConnection();
            prst=conn.prepareStatement(sql);
            rs=prst.executeQuery();
            while (rs.next()){
                UserMessage message=new UserMessage();
                message.setUsername(rs.getString("username"));
                message.setMessageID(rs.getInt("id"));
                message.setMessageTitle(rs.getString("messageTitle"));
                message.setMessageContent(rs.getString("messageContent"));
                message.setMessageTime(rs.getTimestamp("create_time").toString());
                messages.add(message);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(rs);
            dbUtil.close(prst);
            dbUtil.close(conn);
        }
        return messages;
    }
}
