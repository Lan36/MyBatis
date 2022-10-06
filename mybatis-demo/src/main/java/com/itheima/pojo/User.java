package com.itheima.pojo;

/**
 * @Author:兰
 * @Date:2022/10/03/17:22
 */
//alt + 鼠标左键 整列编辑
public class User {
    private Integer id        ;
    private String username;
    private String password;
    private String gender;
    private String addr;

    public User(Integer id, String username, String password, String gender, String addr) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
