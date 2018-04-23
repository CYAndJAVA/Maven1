package com.stu.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.stu.entity.User;
import com.stu.mapper.UserMapper;
import com.stu.service.IUser;
import com.stu.util.MybatisUtil;

public class UserImpl implements IUser{
    private UserMapper mapper;
    private SqlSession session;
    @Override
    public User getByUserName(String username) {
        session = MybatisUtil.getSqlSession();
        mapper = session.getMapper(UserMapper.class);
        User user = mapper.getByUserName(username);
        session.close();
        return user;
    }
    @Override
    public void insertUser(User user) {
        session = MybatisUtil.getSqlSession();
        mapper = session.getMapper(UserMapper.class);
        mapper.insertUser(user);
        session.commit();
        session.close();
    }

}
