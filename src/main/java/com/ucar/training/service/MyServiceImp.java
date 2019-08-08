package com.ucar.training.service;

import com.ucar.training.dao.MyDaoImp;
import com.ucar.training.entity.User;
import com.ucar.training.entity.UserMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyServiceImp implements MyService {
    private User userNow;
    @Override
    public void initUsers() {
        MyDaoImp myDaoImp=new MyDaoImp();
        myDaoImp.initUsers();
    }

    @Override
    public void register(User user) {
        MyDaoImp myDaoImp=new MyDaoImp();
        myDaoImp.addUser(user);
    }

    @Override
    public int login(String username, String password) {
        int var=2;
        MyDaoImp myDaoImp=new MyDaoImp();
        if (myDaoImp.inquireUser(username)){
            User user=myDaoImp.findUser(username);
            if (user.getUsername().equals(username)){
                if (user.getPassword().equals(password)){
                    //密码正确
                    userNow=user;
                    var=0;
                }
                else {
                    //密码不正确
                    var=1;
                }
            }
        }
        return var;
    }

    @Override
    public void delUser(String username) {
        MyDaoImp myDaoImp=new MyDaoImp();
        User user=myDaoImp.findUser(username);
        myDaoImp.delUser(user);
    }

    @Override
    public void updateUser(String username,String realName,String age,String tel,String email) {
        MyDaoImp myDaoImp=new MyDaoImp();
        User user=myDaoImp.findUser(username);
        this.delUser(username);
        user.setRealName(realName);
        user.setAge(age);
        user.setTel(tel);
        user.setEmail(email);
        myDaoImp.addUser(user);
    }
    public boolean inUsers(String username){
        MyDaoImp myDaoImp=new MyDaoImp();
        return myDaoImp.inquireUser(username);
    }
    @Override
    public User findUser(String username) {
        MyDaoImp myDaoImp=new MyDaoImp();
        return myDaoImp.findUser(username);
    }

    @Override
    public Set<String> getUsernameSet() {
        MyDaoImp myDaoImp=new MyDaoImp();
        return myDaoImp.getUsernameSet();
    }

    @Override
    public Set<User> getUsers() {
        MyDaoImp myDaoImp=new MyDaoImp();
        return myDaoImp.getUsers();
    }
    @Override
    public User getUserNow() {
        return userNow;
    }

    @Override
    public void addMessage(UserMessage userMessage) {
        MyDaoImp myDaoImp=new MyDaoImp();
        myDaoImp.addMessage(userMessage);
    }

    @Override
    public void delMessage(int messageID) {
        MyDaoImp myDaoImp=new MyDaoImp();
        myDaoImp.delMessage(myDaoImp.findMessage(messageID));
    }

    @Override
    public ArrayList<UserMessage> getUserMessages() {
        MyDaoImp myDaoImp=new MyDaoImp();
        return myDaoImp.getUserMessages();
    }
}
