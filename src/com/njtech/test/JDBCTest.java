package com.njtech.test;

import com.njtech.dao.impl.UserDaoImpl;
import com.njtech.entity.User;

/**
 * @autor jianz
 * @create 2021-01-06 11:01
 * @desc 测试jdbc连接的类
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        User user = userDaoImpl.selectUser(1);
        System.out.println(user);
    }
}
