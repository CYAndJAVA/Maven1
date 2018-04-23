package com.stu.mapper;

import com.stu.entity.User;

public interface UserMapper {
    public User getByUserName(String username);
    public void insertUser(User user);
}
