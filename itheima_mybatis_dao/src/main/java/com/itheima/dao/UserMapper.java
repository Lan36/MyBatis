package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @Author:兰
 * @Date:2022/10/05/17:32
 */
public interface UserMapper {
    public List<User> findAll();
    User findById(int id);
}
