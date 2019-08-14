package com.ucar.training.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String username;
    private String realName;
    private String sex;
    private String age;
    private String password;
    private String tel;
    private String email;
    private String privilege;
    private String hobbies;
    private ArrayList<String> hobbyList=new ArrayList<>(4);
    private String sign;

    public User(){

    }
    public User(String username, String realName, String userSex, String userAge, String password, String tel, String email){
        this.username=username;
        this.realName=realName;
        this.sex=userSex;
        this.age=userAge;
        this.password=password;
        this.tel=tel;
        this.email=email;
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

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
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

    public ArrayList<String> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList() {
         String[] hobbiesArr=this.hobbies.split(",");
        for (int i = 0; i <hobbiesArr.length ; i++) {
            hobbyList.add(hobbiesArr[i]);
        }
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


}