package com.itheima.mapper;

import com.itheima.domain.User;

import java.util.List;

/**
 * @Author:兰
 * @Date:2022/10/06/16:08
 */

public interface UserMapper {
    List<User> findByCondition(User user);
}
