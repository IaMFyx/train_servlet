package com.ucar.training.service;

import com.ucar.training.entity.User;
import com.ucar.training.entity.UserMessage;

import java.util.ArrayList;
import java.util.Set;

public interface MyService {
    //初始用户集合
    public void initUsers();
    //用户注册
    public void register(User user);
    //用户登录
    public int login(String username,String password);
    //删除用户
    public void delUser(String username);
    //更新用户信息
    public void updateUser(String username,String realName,String age,String tel,String email);
    //查找用户
    public User findUser(String username);
    //查询用户是否已经注册
    public boolean inUsers(String username);
    //返回用户集合
    public Set<User> getUsers();
    //返回用户名集合
    public Set<String> getUsernameSet();
    //返回当前登录的用户
    public User getUserNow();
    //添加留言
    public void addMessage(UserMessage userMessage);
    //删除留言
    public void delMessage(int messageID);
    //返回留言板
    public ArrayList<UserMessage> getUserMessages();
}
