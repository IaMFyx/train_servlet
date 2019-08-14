package com.ucar.training.service;

import com.ucar.training.entity.User;
import java.util.ArrayList;

public interface UserService {
//    //初始用户集合
//    public void initUsers();
    //用户注册
    public void register(User user);
    //用户登录
    public int login(String username,String password);
    //删除用户
    public void delUser(String username);
    //更新用户信息
    public void updateUser(User user);
    //查找用户
    public User findUser(String username);
    //查询用户是否已经注册
    public boolean inUsers(String username);
    //返回用户集合
    public ArrayList<User> getUsers();
    //返回当前登录的用户
    public User getUserNow();
}
