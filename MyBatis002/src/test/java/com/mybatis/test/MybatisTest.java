package com.mybatis.test;

import com.mybatis.mapper.UserInfoMapper;
import com.mybatis.pojo.UserInfo;
import com.mybatis.utils.MybatisUtils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    //根据用户ID查信息
    @Test
    public void findUserByIdTest() throws IOException{
        /*//1、读取配置文件
        String resource="mybatis-config.xml";
        //   得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2、根据配置文件信息，创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3、通过工厂得到sqlSession
        SqlSession sqlsession = sqlSessionFactory.openSession();*/
        SqlSession sqlsession = MybatisUtils.getSession();
        //4、执行映射文件中的sql并返回映射结果
        //    UserInfo userinfo = sqlsession.selectOne("com.mybatis.mapper.UserInfoMapper.findUserInfoById",1);
        //4.调用接口中的方法执行sql
        UserInfoMapper usermapper = sqlsession.getMapper(UserInfoMapper.class);
        UserInfo userinfo = usermapper.findUserInfoById(1);
        //5、打印输出结果
        System.out.println(userinfo.toString());
        //6、关闭sqlsession
        sqlsession.close();
    }
    @Test
    public void findUserInfoByNameTest() throws IOException{
        SqlSession sqlsession = MybatisUtils.getSession();
        //       List<UserInfo> users=sqlsession.selectList("com.mybatis.mapper.UserInfoMapper.findUserInfoByName","张");
        UserInfoMapper usermapper = sqlsession.getMapper(UserInfoMapper.class);
        List<UserInfo> users = usermapper.findUserInfoByName("张");
        for (UserInfo user : users){
            System.out.println(user.toString());
        }

        //6、关闭sqlsession
        sqlsession.close();
    }
    @Test
    public void addUserInfoTest() throws IOException {
        SqlSession sqlsession = MybatisUtils.getSession();
        //创建User对象
        UserInfo user = new UserInfo();
        user.setuName("李雷");
        user.setUpass("666");
        //执行插入方法
        /*int rows=sqlsession.insert("com.mybatis.mapper.UserInfoMapper.addUserInfo",user);
        if(rows>0){
            System.out.println("插入了"+ rows + "条数据");
        }else{
            System.out.println("插入失败");
        }*/
        UserInfoMapper usermapper = sqlsession.getMapper(UserInfoMapper.class);
        usermapper.addUserInfo(user);
        System.out.println("插入成功");
        System.out.println(user.getUid());
        //提交事务
        sqlsession.commit();
        //6.关闭sqlsession
        sqlsession.close();
    }
    @Test
    public void updateUserInfoTest() throws IOException {
        SqlSession sqlsession = MybatisUtils.getSession();
        //加载编号为2的对象
        UserInfo user=sqlsession.selectOne("com.mybatis.mapper.UserInfoMapper.findUserInfoById",2);
        user.setUpass("789");
        int rows = sqlsession.update("com.mybatis.mapper.UserInfoMapper.updateUserInfo",user);
        /*if(rows>0){
            System.out.println("修改了"+ rows + "条数据");
        }else{
            System.out.println("修改失败");
        }*/
        UserInfoMapper usermapper = sqlsession.getMapper(UserInfoMapper.class);
        usermapper.addUserInfo(user);
        System.out.println("修改成功");
        //提交事务
        sqlsession.commit();
        //6.关闭sqlsession
        sqlsession.close();
    }
//    @Test
//    public void deleteUserInfoTest() throws IOException {
//       SqlSession sqlsession = MybatisUtils.getSession();
//       //加载编号为8的对象
//        int id = 4;
//        int rows = sqlsession.delete("com.mybatis.mapper.UserInfoMapper.deleteUserInfo",id);
//        UserInfoMapper usermapper = sqlsession.getMapper(UserInfoMapper.class);
//        usermapper.addUserInfo(user);
//        System.out.println("删除成功");
//        //提交事务
//        sqlsession.commit();
//        //6.关闭sqlsession
//        sqlsession.close();
//    }

}
