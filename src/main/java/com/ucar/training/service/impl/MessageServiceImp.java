package com.ucar.training.service.impl;

import com.ucar.training.dao.MessageDao;
import com.ucar.training.entity.UserMessage;
import com.ucar.training.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("messageService")
public class MessageServiceImp implements MessageService {
    @Resource(name = "messageDao")
    private MessageDao messageDao;
    @Override
    public void addMessage(UserMessage userMessage) {
        messageDao.addMessage(userMessage);
    }

    @Override
    public void delMessage(int messageID) {
        messageDao.delMessage(messageID);
    }

    @Override
    public ArrayList<UserMessage> getUserMessages() {
        return messageDao.selectAllMessages();
    }
}
