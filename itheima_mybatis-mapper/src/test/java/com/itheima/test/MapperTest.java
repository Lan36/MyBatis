package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author:兰
 * @Date:2022/10/06/16:18
 */
public class MapperTest {
    @Test
    public void test1() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //模拟条件User
        User condition= new User();
        condition.setId(1);
        condition.setUsername("zhangsan");
        condition.setPassword("123");
        List<User> userList = mapper.findByCondition(condition);

        System.out.println(userList);
    }
}
