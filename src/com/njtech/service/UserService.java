package com.njtech.service;

import com.njtech.entity.User;

import java.util.List;

/**
 * @autor
 * @create 2021-01-06 14:07
 * @desc
 */

public interface UserService {
    /**
     * 新增用户简历信息
     * @param user 用户简历对象
     * @return 1表示成功
     */
    int add(User user) throws Exception;

    /**
     * 修改用户简历信息
     * @param user 用户简历对象
     * @return 1表示成功
     */
    int modify(User user) throws Exception;

    /**
     * 删除用户简历信息
     * @param id 用户主键列
     * @return 1表示成功
     */
    int remove(Integer id) throws Exception;

    /**
     * 查询用户简历列表
     * @return
     */
    List<User> queryList() throws Exception;

    /**
     * 查询用户简历列表
     * @param username 用户姓名
     * @return
     */
    List<User> queryList(String username) throws Exception;

    /**
     * 查询某个用户的简历信息
     * @param id 用户主键列
     * @return
     */
    User queryUser(Integer id) throws Exception;
}

