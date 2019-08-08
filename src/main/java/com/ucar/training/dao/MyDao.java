package com.ucar.training.dao;

import com.ucar.training.entity.User;
import com.ucar.training.entity.UserMessage;

import java.util.ArrayList;
import java.util.Set;

public interface MyDao {
    //添加用户
    public void addUser(User user);
    //返回用户集合
    public Set<User> getUsers();
    //返回用户名集合
    public Set<String> getUsernameSet();
    //初始用户集合
    public void initUsers();
    //查询用户名是否注册
    public boolean inquireUser(String username);
    //查找用户
    public User findUser(String username);
    //删除用户
    public void delUser(User user);
    //添加留言
    public void addMessage(UserMessage userMessage);
    //删除留言
    public void delMessage(UserMessage userMessage);
    //返回留言
    public ArrayList<UserMessage> getUserMessages();
    //查找留言
    public UserMessage findMessage(int messageID);
}
