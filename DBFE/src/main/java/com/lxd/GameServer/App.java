package com.lxd.GameServer;

import com.lxd.GameServer.bean.User;
import com.lxd.GameServer.dao.UserMapper;
import com.lxd.GameServer.mybatis.Mybatis;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Object goodCopyOf(List<?> a)
    {
        if (a.isEmpty())
        {
            return null;
        }

        Class componentType = a.get(0).getClass();
        System.out.println(componentType.getName());

        return null;
    }

    public void findById(int userId) throws Exception {
        //Class c = Mybatis.getInstance().getAlias("com.lxd.GameServer.dao.UserMapper");
        Class c = Class.forName("com.lxd.GameServer.dao.UserMapper");
        SqlSession sqlSession = Mybatis.getInstance().getSqlSession();
        Object userMapper = sqlSession.getMapper(c);
        Method m = c.getMethod("findAllUsers");
        //System.out.println(m.invoke(sqlSession.getMapper(c)));
        List<?> users = (List<?>) m.invoke(sqlSession.getMapper(c));
        App.goodCopyOf(users);

        Class classUser = Mybatis.getInstance().getAlias("User");

//        List<User> users = userMapper.findAllUsers();
//        for (User u : users)
//        {
//            System.out.println(u.getId());
//        }

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
