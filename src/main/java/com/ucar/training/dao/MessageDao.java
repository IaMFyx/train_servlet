package com.ucar.training.dao;

import com.ucar.training.entity.UserMessage;

import java.util.ArrayList;

public interface MessageDao {
    //添加留言
    public void addMessage(UserMessage userMessage);
    //删除留言
    public void delMessage(int messageID);
    //返回留言
    public ArrayList<UserMessage> selectAllMessages();
}
