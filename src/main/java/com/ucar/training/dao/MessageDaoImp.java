package com.ucar.training.dao;

import com.ucar.training.entity.UserMessage;
import java.util.ArrayList;

public class MessageDaoImp implements MessageDao {
    private static ArrayList<UserMessage> userMessages=new ArrayList<>();
    @Override
    public void addMessage(UserMessage userMessage) {
        userMessages.add(userMessage);
    }

    @Override
    public void delMessage(UserMessage userMessage) {
        userMessages.remove(userMessage);
    }

    @Override
    public ArrayList<UserMessage> getUserMessages() {
        return userMessages;
    }

    @Override
    public UserMessage findMessage(int messageID) {
        UserMessage userMessage=new UserMessage();
        for (UserMessage userMessage1:userMessages){
            if (userMessage1.getMessageID()==messageID){
                userMessage=userMessage1;
                break;
            }
        }
        return userMessage;
    }
}
