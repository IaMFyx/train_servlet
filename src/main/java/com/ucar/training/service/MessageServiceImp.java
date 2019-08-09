package com.ucar.training.service;

import com.ucar.training.dao.MessageDaoImp;
import com.ucar.training.dao.UserDaoImp;
import com.ucar.training.entity.UserMessage;

import java.util.ArrayList;

public class MessageServiceImp implements MessageService{
    @Override
    public void addMessage(UserMessage userMessage) {
        MessageDaoImp messageDaoImp=new MessageDaoImp();
        messageDaoImp.addMessage(userMessage);
//        UserDaoImp myDaoImp=new UserDaoImp();
//        myDaoImp.addMessage(userMessage);
    }

    @Override
    public void delMessage(int messageID) {
        MessageDaoImp messageDaoImp=new MessageDaoImp();
        messageDaoImp.delMessage(messageDaoImp.findMessage(messageID));
//        UserDaoImp myDaoImp=new UserDaoImp();
//        myDaoImp.delMessage(myDaoImp.findMessage(messageID));
    }

    @Override
    public ArrayList<UserMessage> getUserMessages() {
        MessageDaoImp messageDaoImp=new MessageDaoImp();
        return messageDaoImp.getUserMessages();
//        UserDaoImp myDaoImp=new UserDaoImp();
//        return myDaoImp.getUserMessages();
    }
}
