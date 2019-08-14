package com.ucar.training.util;

import java.sql.*;

public class DBUtil {
    private static final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/demo?characterEncoding=UTF-8";
    private static final String USER_NAME="root";
    private static final String PASSWORD="iamfyx";

    public Connection getConnection(){
        Connection connection=null;
        try{
            Class.forName(DRIVER_NAME);
            connection= DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    public void close(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void close(PreparedStatement preparedStatement){
        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void close(ResultSet resultSet){
        if (resultSet!=null){
            try {
                resultSet.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
