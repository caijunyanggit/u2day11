package cn.kgc.domain;

import java.util.Date;

public class User {
    private int id;
    private String uname;
    private String upwd;
    private Date loginTime;

    public User() {
    }

    public User(int id, String uname, String upwd, Date loginTime) {
        this.id = id;
        this.uname = uname;
        this.upwd = upwd;
        this.loginTime = loginTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
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
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}
