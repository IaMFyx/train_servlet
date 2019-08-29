package com.ucar.training.service.impl;

import com.ucar.training.dao.UserDao;
import com.ucar.training.entity.TMenu;
import com.ucar.training.entity.User;
import com.ucar.training.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;

@Service("userService")
public class UserServiceImp implements UserService {
    @Resource(name = "userDao")
    private UserDao myDaoImp;
    @Override
    public void register(User user) {
        myDaoImp.addUser(user);
    }

    @Override
    public int login(String username, String password) {
        int var=2;
        User user=myDaoImp.selectUser(username);
        if (user!=null){
            if (user.getUsername().equals(username)){
                if (user.getPassword().equals(password)){
                    //密码正确
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
        myDaoImp.delUser(username);
    }

    @Override
    public void updateUser(User user) {
        myDaoImp.modifyUser(user);
    }

    @Override
    public boolean inUsers(String username){
         User user=myDaoImp.selectUser(username);
         return user!=null;
    }

    @Override
    public User findUser(String username) {
        return myDaoImp.selectUser(username);
    }

    @Override
    public ArrayList<User> getUsers() {
        return myDaoImp.selectAllUser();
    }

    @Override
    public ArrayList<TMenu> getUserMenu(User userNow) {
        return myDaoImp.selectUserMenu(userNow.getRole());
    }
}
