package com.ucar.training;

public class User {
    private String username;
    private String realName;
    private String userSex;
    private String userAge;
    private String password;
    private String tel;
    private String email;
//        public User(String username, String realName, String userSex, String userAge, String password, String tel, String email){
//            this.username=username;
//            this.realName=realName;
//            this.userSex=userSex;
//            this.userAge=userAge;
//            this.password=password;
//            this.tel=tel;
//            this.email=email;
//        }

    public String getPassword() {
        return password;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getTel() {
        return tel;
    }

    public String getUserAge() {
        return userAge;
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
    public String getUserSex() {
        return userSex;
    }

    public String getEmail() {
        return email;
    }
}
