package com.stu.service;

import com.stu.entity.User;

public interface IUser {
    public User getByUserName(String username);
    public void insertUser(User user);
}
