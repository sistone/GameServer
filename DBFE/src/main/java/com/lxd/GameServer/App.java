package com.lxd.GameServer;

import com.lxd.GameServer.bean.User;
import com.lxd.GameServer.dao.UserMapper;
import com.lxd.GameServer.mybatis.Mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public void findById(int userId)
    {
        SqlSession sqlSession = Mybatis.getInstance().getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(2012003);
        user.setName("o my god");
        userMapper.insert(user);
        sqlSession.commit();

        List<User> users = userMapper.findAllUsers();
        for (User u : users)
        {
            System.out.println(u.getId());
        }

        sqlSession.close();
    }

    public static void main( String[] args )
    {
        try {
            Mybatis.getInstance().init();

            App app = new App();
            app.findById(2012001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
