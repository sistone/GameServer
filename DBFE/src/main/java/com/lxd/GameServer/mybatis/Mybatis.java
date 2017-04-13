package com.lxd.GameServer.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by luoxiaodong on 2017/4/13.
 */
public class Mybatis {
    private static Mybatis ourInstance = new Mybatis();
    private SqlSessionFactory sqlSessionFactory = null;

    public static Mybatis getInstance() {
        return ourInstance;
    }

    private Mybatis() {
    }

    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
