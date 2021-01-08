package com.njtech.service.impl;

import com.njtech.dao.UserDao;
import com.njtech.dao.impl.UserDaoImpl;
import com.njtech.entity.User;
import com.njtech.service.UserService;

import java.util.List;

/**
 * @autor
 * @create 2021-01-06 14:09
 * @desc
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        // TODO:紧耦合关系
        this.userDao = new UserDaoImpl();
    }

    @Override
    public int add(User user) throws Exception {
        return this.userDao.insert(user);
    }

    @Override
    public int modify(User user) throws Exception {
        return this.userDao.update(user);
    }

    @Override
    public int remove(Integer id) throws Exception {
        return this.userDao.delete(id);
    }

    @Override
    public List<User> queryList() throws Exception {
        return this.userDao.selectList();
    }

    @Override
    public List<User> queryList(String username) throws Exception {
        return this.userDao.selectList(username);
    }

    @Override
    public User queryUser(Integer id) throws Exception {
        return this.userDao.selectUser(id);
    }
}
