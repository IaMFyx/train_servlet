package com.ucar.training.service;

import com.ucar.training.dao.UserDaoImp;
import com.ucar.training.entity.User;
import java.util.ArrayList;


public class UserServiceImp implements UserService {
    private User userNow;
    @Override
    public void register(User user) {
        UserDaoImp myDaoImp=new UserDaoImp();
        myDaoImp.addUser(user);
    }

    @Override
    public int login(String username, String password) {
        int var=2;
        UserDaoImp myDaoImp=new UserDaoImp();
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
        UserDaoImp myDaoImp=new UserDaoImp();
        myDaoImp.delUser(username);
    }

    @Override
    public void updateUser(User user) {
        UserDaoImp myDaoImp=new UserDaoImp();
        myDaoImp.modifyUser(user);
    }

    @Override
    public boolean inUsers(String username){
        UserDaoImp myDaoImp=new UserDaoImp();
        return myDaoImp.inquireUser(username);
    }

    @Override
    public User findUser(String username) {
        UserDaoImp myDaoImp=new UserDaoImp();
        return myDaoImp.findUser(username);
    }

    @Override
    public ArrayList<User> getUsers() {
        UserDaoImp myDaoImp=new UserDaoImp();
        return myDaoImp.findAllUser();
    }

    @Override
    public User getUserNow() {
        return userNow;
    }
}
