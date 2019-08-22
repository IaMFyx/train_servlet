package com.ucar.training.service;

import com.ucar.training.entity.TMenu;
import com.ucar.training.entity.User;
import java.util.ArrayList;

public interface UserService {

    /**
     * 用户注册
     * @param user
     */
    void register(User user);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    int login(String username,String password);

    /**
     * 删除用户
     * @param username
     */
    void delUser(String username);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 查找用户
     * @param username
     * @return
     */
    User findUser(String username);

    /**
     * 查询用户是否已经注册
     * @param username
     * @return
     */
    boolean inUsers(String username);

    /**
     * 返回所有信息
     * @return
     */
    ArrayList<User> getUsers();

    /**
     * 返回当前登录的用户
     * @return
     */
    User getUserNow();

    /**
     * 当前用户可见的菜单
     */
    ArrayList<TMenu> getUserMenu();
}
