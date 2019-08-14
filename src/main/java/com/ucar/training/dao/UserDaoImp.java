package com.ucar.training.dao;

import com.ucar.training.entity.User;
import com.ucar.training.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

public class UserDaoImp implements UserDao {
    private DBUtil dbUtil=new DBUtil();
    @Override
    public void addUser(User user) {
        String sql="INSERT INTO users(用户名,密码,姓名,性别,年龄,电话,邮箱,权限,爱好,个性签名) VALUES(?,?,?,?,?,?,?,?,?,?)";
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=dbUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getRealName());
            preparedStatement.setString(4,user.getSex());
            preparedStatement.setString(5,user.getAge());
            preparedStatement.setString(6,user.getTel());
            preparedStatement.setString(7,user.getEmail());
            preparedStatement.setString(8,user.getPrivilege());
            preparedStatement.setString(9,user.getHobbies());
            preparedStatement.setString(10,user.getSign());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(preparedStatement);
            dbUtil.close(connection);
        }
    }

    @Override
    public void delUser(String username) {
        String sql="DELETE FROM users WHERE 用户名=?";
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=dbUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(preparedStatement);
            dbUtil.close(connection);
        }
    }
    @Override
    public boolean inquireUser(String username) {
        String sql="SELECT 用户名 FROM users WHERE 用户名=?";
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        boolean result=false;
        try {
            connection=dbUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                result=true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(resultSet);
            dbUtil.close(preparedStatement);
            dbUtil.close(connection);
        }
        return result;
    }

    @Override
    public User findUser(String username) {
        String sql="SELECT * FROM users WHERE 用户名=?";
        User user=new User();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection=dbUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                user.setUsername(resultSet.getString("用户名"));
                user.setRealName(resultSet.getString("姓名"));
                user.setPassword(resultSet.getString("密码"));
                user.setSex(resultSet.getString("性别"));
                user.setAge(resultSet.getString("年龄"));
                user.setTel(resultSet.getString("电话"));
                user.setEmail(resultSet.getString("邮箱"));
                user.setPrivilege(resultSet.getString("权限"));
                user.setHobbies(resultSet.getString("爱好"));
                user.setHobbyList();
                user.setSign(resultSet.getString("个性签名"));
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(resultSet);
            dbUtil.close(preparedStatement);
            dbUtil.close(connection);
        }
        return user;
    }

    @Override
    public ArrayList<User> findAllUser() {
        String sql="SELECT * FROM users";
        ArrayList<User> users=new ArrayList<>();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection=dbUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                User user=new User();
                user.setUsername(resultSet.getString("用户名"));
                user.setRealName(resultSet.getString("姓名"));
                user.setPassword(resultSet.getString("密码"));
                user.setSex(resultSet.getString("性别"));
                user.setAge(resultSet.getString("年龄"));
                user.setTel(resultSet.getString("电话"));
                user.setEmail(resultSet.getString("邮箱"));
                user.setPrivilege(resultSet.getString("权限"));
                user.setHobbies(resultSet.getString("爱好"));
                user.setHobbyList();
                user.setSign(resultSet.getString("个性签名"));
                users.add(user);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(resultSet);
            dbUtil.close(preparedStatement);
            dbUtil.close(connection);
        }
        return users;
    }
    @Override
    public void modifyUser(User user){
        String sql="UPDATE users SET 姓名=?,性别=?,年龄=?,电话=?,邮箱=?,爱好=?,个性签名=?WHERE 用户名=?";

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=dbUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getRealName());
            preparedStatement.setString(2,user.getSex());
            preparedStatement.setString(3,user.getAge());
            preparedStatement.setString(4,user.getTel());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.setString(6,user.getHobbies());
            preparedStatement.setString(7,user.getSign());
            preparedStatement.setString(8,user.getUsername());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close(preparedStatement);
            dbUtil.close(connection);
        }
    }
}
