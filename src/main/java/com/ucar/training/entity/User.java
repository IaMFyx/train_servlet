package com.ucar.training.entity;

import java.io.Serializable;

public class User implements Serializable {

    private  int id;
    private String username;
    private String realName;
    private String sex;
    private String age;
    private String password;
    private String tel;
    private String email;
    private int role;
    private String hobbies;
    private String sign;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(String userAge) {
        this.age = userAge;
    }

    public void setSex(String userSex) {
        this.sex = userSex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public String getAge() {
        return age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        if (hobbies==null){
            this.hobbies="无";
        }
        else {
            this.hobbies = hobbies;
        }
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


}