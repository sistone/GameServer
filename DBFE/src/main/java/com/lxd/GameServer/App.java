package com.lxd.GameServer;

import com.lxd.GameServer.bean.User;
import com.lxd.GameServer.mybatis.Mybatis;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Mybatis.getInstance().init();

            SqlSession sqlSession = Mybatis.getInstance().getSqlSession();
            //UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            //User user = mapper.findById(2012001);
            User user = sqlSession.selectOne("findById", 2012001);
            System.out.println(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
