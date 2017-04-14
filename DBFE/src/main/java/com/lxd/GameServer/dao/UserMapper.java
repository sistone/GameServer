package com.lxd.GameServer.dao;

import com.lxd.GameServer.bean.User;

import java.util.List;

/**
 * Created by luoxiaodong on 2017/4/14.
 */
public interface UserMapper {
    public void insert(User user);
    public User findById(int userId);
    public List<User> findAllUsers();
}
