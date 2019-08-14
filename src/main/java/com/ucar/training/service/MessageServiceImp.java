package com.ucar.training.service;

import com.ucar.training.dao.MessageDaoImp;
import com.ucar.training.entity.UserMessage;

import java.util.ArrayList;

public class MessageServiceImp implements MessageService{
    @Override
    public void addMessage(UserMessage userMessage) {
        MessageDaoImp messageDaoImp=new MessageDaoImp();
        messageDaoImp.addMessage(userMessage);
    }

    @Override
    public void delMessage(int messageID) {
        MessageDaoImp messageDaoImp=new MessageDaoImp();
        messageDaoImp.delMessage(messageID);
    }

    @Override
    public ArrayList<UserMessage> getUserMessages() {
        MessageDaoImp messageDaoImp=new MessageDaoImp();
        return messageDaoImp.findAllMessages();
    }
}
