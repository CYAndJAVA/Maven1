package com.stu.usertest;


import org.junit.Test;

import com.stu.entity.User;
import com.stu.service.IUser;
import com.stu.service.impl.UserImpl;

public class UserServiceTest {
    private IUser iuser = new UserImpl();
    
    @Test
    public void TestgetByUserName(){
        User user = iuser.getByUserName("aa");
        System.out.println(user);
    }
    @Test
    public void TestInsertUserByUser(){
        User user1 = new User("cc", "cc", 1);
        iuser.insertUser(user1);
    }
}
