package cn.kgc.domain;

import java.util.Date;

public class User {
    private int id;
    private String userName;
    private String userPwd;
    private Date loginTime;

    public User() {
    }

    public User(int id, String userName, String userPwd, Date loginTime) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.loginTime = loginTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}
