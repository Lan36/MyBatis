package com.mybatis.mapper;

import java.util.List;

import com.mybatis.pojo.UserInfo;

public interface UserInfoMapper {
    /*
     * 1.接口中的方法名和mapper.xml（映射文件）中标签的id值相同
     * 2.方法中的输入参数和mapper.xml文件中的标签的parameterType 类型一致
     * 3.方法的返回值和mapper.xml文件中标签的resulType类型一致
     * 映射文件中的namespace的值就是接口的全类名（接口和映射文件一一对应了）
     * 根据接口名找到映射文件，根据方法名找到对应的标签，以上可以通过接口的方法定位到SQL
     */
    //根据用户id查询用户信息
    UserInfo findUserInfoById(int id);
    //根据用户名模糊查询用户信息
    List<UserInfo> findUserInfoByName(String username);
    //添加用户信息
    void addUserInfo(UserInfo user);
    //修改用户信息
    void updateInfo(UserInfo user);
    //删除用户信息
    void deleteInfo(int id);

}
