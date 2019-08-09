package com.ucar.training.dao;

import com.ucar.training.entity.UserMessage;

import java.util.ArrayList;

public interface MessageDao {
    //添加留言
    public void addMessage(UserMessage userMessage);
    //删除留言
    public void delMessage(UserMessage userMessage);
    //返回留言
    public ArrayList<UserMessage> getUserMessages();
    //查找留言
    public UserMessage findMessage(int messageID);
}
