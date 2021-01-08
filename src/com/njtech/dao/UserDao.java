package com.njtech.dao;

import com.njtech.entity.User;

import java.util.List;

/**
 * @autor jianz
 * @create 2021-01-06 10:46
 * @desc 用户表对应的dao data to object
 */

public interface UserDao {
    /**
     * 新增用户简历信息
     * @param user 用户简历对象
     * @return 1表示成功
     */
    int insert(User user) throws Exception;

    /**
     * 修改用户简历信息
     * @param user 用户简历对象
     * @return 1表示成功
     */
    int update(User user) throws Exception;

    /**
     * 删除用户简历信息
     * @param id 用户主键列
     * @return 1表示成功
     */
    int delete(Integer id) throws Exception;

    /**
     * 查询用户简历列表
     * @return
     */
    List<User> selectList() throws Exception;

    /**
     * 查询用户简历列表
     * @param username 用户姓名
     * @return
     */
    List<User> selectList(String username) throws Exception;

    /**
     * 查询某个用户的简历信息
     * @param id 用户主键列
     * @return
     */
    User selectUser(Integer id) throws Exception;
}
