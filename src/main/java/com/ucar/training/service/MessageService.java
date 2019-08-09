package com.ucar.training.service;

import com.ucar.training.entity.UserMessage;

import java.util.ArrayList;

public interface MessageService {
    //添加留言
    public void addMessage(UserMessage userMessage);
    //删除留言
    public void delMessage(int messageID);
    //返回留言板
    public ArrayList<UserMessage> getUserMessages();
}
