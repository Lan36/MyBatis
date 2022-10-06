package com.mybatis.pojo;

import java.sql.Date;

/**
 * @author 兰皓宇~
 * @version 1.0
 */
public class UserInfo {
    private int uid;
    private String  uname;
    private String upass;
    private String realName;
    private String sex;
    private String address;
    private String email;
    private Date regDate;
    private int status;
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getuName() {
        return uname;
    }
    public void setuName(String uName) {
        this.uname = uName;
    }
    public String getUpass() {
        return upass;
    }
    public void setUpass(String upass) {
        this.upass = upass;
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + uid +
                ", userName='" + uname + '\'' +
                ", password='" + upass + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", regDate=" + regDate +
                ", status=" + status +
                '}';
    }
}


