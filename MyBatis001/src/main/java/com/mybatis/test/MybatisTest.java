package com.mybatis.test;

import java.io.IOException;


import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.pojo.UserInfo;

public class MybatisTest {
    //根据用户ID查信息
    @Test
    public void findUserByIdTest() throws IOException{
        //1、读取配置文件
        String resource="mybatis-config.xml";
        //   得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2、根据配置文件信息，创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3、通过工厂得到sqlSession
        SqlSession sqlsession = sqlSessionFactory.openSession();
        //4、执行映射文件中的sql并返回映射结果
        UserInfo userinfo = sqlsession.selectOne("com.mybatis.mapper.UserInfoMapper.findUserInfoById",1);
        //5、打印输出结果
        System.out.println(userinfo.toString());
        //6、关闭sqlsession
        sqlsession.close();
    }
}
