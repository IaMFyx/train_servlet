package com.ucar.training.service;

import com.ucar.training.dao.UserDaoImp;
import com.ucar.training.entity.User;
import com.ucar.training.entity.UserMessage;
import java.util.ArrayList;
import java.util.Set;

public class UserServiceImp implements UserService {
    private User userNow;
    @Override
    public void initUsers() {
        UserDaoImp myDaoImp=new UserDaoImp();
        myDaoImp.initUsers();
    }

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
        User user=myDaoImp.findUser(username);
        myDaoImp.delUser(user);
    }

    @Override
    public void updateUser(String username,String realName,String age,String tel,String email) {
        UserDaoImp myDaoImp=new UserDaoImp();
        User user=myDaoImp.findUser(username);
        this.delUser(username);
        user.setRealName(realName);
        user.setAge(age);
        user.setTel(tel);
        user.setEmail(email);
        myDaoImp.addUser(user);
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
    public Set<String> getUsernameSet() {
        UserDaoImp myDaoImp=new UserDaoImp();
        return myDaoImp.getUsernameSet();
    }

    @Override
    public Set<User> getUsers() {
        UserDaoImp myDaoImp=new UserDaoImp();
        return myDaoImp.getUsers();
    }

    @Override
    public User getUserNow() {
        return userNow;
    }
}
