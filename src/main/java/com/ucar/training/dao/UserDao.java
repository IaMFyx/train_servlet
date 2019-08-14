package com.ucar.training.dao;

import com.ucar.training.entity.User;
import java.util.ArrayList;

public interface UserDao {
    //添加用户
    public void addUser(User user);
    //删除用户
    public void delUser(String username);
    //查询用户名是否注册
    public boolean inquireUser(String username);
    //查找用户
    public User findUser(String username);
    //查找所有用户
    public ArrayList<User> findAllUser();
    //修改用户信息
    public void modifyUser(User user);

}
