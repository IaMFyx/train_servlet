package com.ucar.training.dao;

import com.ucar.training.entity.TMenu;
import com.ucar.training.entity.User;
import java.util.ArrayList;

public interface UserDao {
    /**添加用户
     *
     * @param user
     */
    void addUser(User user);

    /**删除用户
     *
     * @param username
     */
    void delUser(String username);

    /**查找用户
     *
     * @param username
     * @return
     */
    User selectUser(String username);

    /**查找所有用户
     *
     * @return
     */
    ArrayList<User> selectAllUser();

    /**修改用户信息
     *
     * @param user
     */
    void modifyUser(User user);

    /**查找用户菜单
     *
     * @param role
     * @return
     */
    ArrayList<TMenu> selectUserMenu(int role);
}
