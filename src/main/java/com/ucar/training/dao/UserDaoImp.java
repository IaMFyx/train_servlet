package com.ucar.training.dao;

import com.ucar.training.entity.User;
import com.ucar.training.entity.UserMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserDaoImp implements UserDao {
    private static Set<User> users=new HashSet<User>();
    private static Set<String> usernameSet=new HashSet<String>();
    private static ArrayList<UserMessage> userMessages=new ArrayList<>();
    public void initUsers(){
        usernameSet.add("admin");
        User admin=new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPrivilege("admin");
        users.add(admin);
    }
    @Override
    public void addUser(User user) {
        usernameSet.add(user.getUsername());
        users.add(user);
    }

    @Override
    public boolean inquireUser(String username) {
        if (usernameSet.contains(username)){
            //用户名已经存在
            return true;
        }
        else {
            //用户名可用
            return false;
        }
    }

    @Override
    public User findUser(String username) {
        User userFound=new User();
        for (User user:users){
            if (user.getUsername().equals(username)){
                userFound=user;
            }
        }
        return userFound;
    }

    @Override
    public void delUser(User user) {
        users.remove(user);
        usernameSet.remove(user.getUsername());
    }

    @Override
    public Set<User> getUsers() {
        return users;
    }

    @Override
    public Set<String> getUsernameSet() {
        return usernameSet;
    }

}
