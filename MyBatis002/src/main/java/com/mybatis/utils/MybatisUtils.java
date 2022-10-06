package com.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author:兰
 * @Date:2022/09/06/23:37
 */
public class MybatisUtils {
    //初始化sqlSessionFactory对象
    private static SqlSessionFactory sqlSessionFactory;
    static{//静态代码块，在虚拟机加载类的时候会加载执行，而且只执行一次
        //1.读取配置文件
        String resource = "mybatis-config.xml";
        //得到配置文件流
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //s获取sqlSession对象的方法
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}
