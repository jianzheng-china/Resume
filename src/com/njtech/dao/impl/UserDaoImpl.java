package com.njtech.dao.impl;

import com.njtech.dao.BaseDao;
import com.njtech.dao.UserDao;
import com.njtech.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor jianz
 * @create 2021-01-06 10:58
 * @desc UserDao的实现类
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int insert(User user) throws Exception {
        String sql = "insert into `user`(`username`,`job`,`cellphone`,`education`,`email`,`address`,`eduDate`,`school`," +
                "`major`,`courseInfo`,`skillInfo`,`workExperience`,`selfEvaluation`,`photo`) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {
                user.getUsername(), user.getJob(), user.getCellphone(), user.getEducation(), user.getEmail(), user.getAddress(),
                user.getEduDate(), user.getSchool(), user.getMajor(), user.getCourseInfo(), user.getSkillInfo(), user.getWorkExperience(),
                user.getSelfEvaluation(), user.getPhoto()
        };
        return this.executeUpdate(sql, params);
    }

    @Override
    public int update(User user) throws Exception {
        String sql = "update user set username=?, address=?, email=?, job=?, cellphone=?, eduDate=?, education=?, " +
                "major=?, school=?, courseInfo=?, skillInfo=?, workExperience=?, selfEvaluation=?, photo=? where id=?";
        Object[] params = {user.getUsername(), user.getAddress(), user.getEmail(), user.getJob(), user.getCellphone(),
                user.getEduDate(), user.getEducation(), user.getMajor(), user.getSchool(), user.getCourseInfo(), user.getSkillInfo(),
                user.getWorkExperience(), user.getSelfEvaluation(), user.getPhoto(), user.getId()};
        return this.executeUpdate(sql, params);
    }

    @Override
    public int delete(Integer id) throws Exception {
        String sql = "delete from user where id=?";
        Object[] params = {id};
        return this.executeUpdate(sql, params);
    }

    @Override
    public List<User> selectList() throws Exception {
        String sql = "select * from user";
        Object[] params = {};
        ResultSet resultSet = this.executeQuery(sql, params);
        List<User> list = new ArrayList<User>();
        User user = null;
        //通过username查的，应该不只有一条记录
        while (resultSet.next()) {
            user = this.tableToClass(resultSet);
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> selectList(String username) throws Exception {
        String sql = "select * from user where username=?";
        Object[] params = {username};
        ResultSet resultSet = null;
        try{
            resultSet = this.executeQuery(sql, params);
        }finally {
            this.closeResource(resultSet);
        }
        List<User> list = new ArrayList<User>();
        User user = null;
        //通过username查的，应该不只有一条记录
        while (resultSet.next()) {
            user = this.tableToClass(resultSet);
            list.add(user);
        }
        return list;
    }

    @Override
    public User selectUser(Integer id) throws Exception {
        ResultSet resultSet = null;
        User user = null;
        try{
            String sql = "select * from user where id=?";
            Object[] params = {id};
            resultSet = this.executeQuery(sql, params);
            //通过id查的，应该是只有一条记录
            if (resultSet.next()) user = this.tableToClass(resultSet);
            return user;
        }finally {
            this.closeResource(resultSet);
        }
    }

    @Override
    public User tableToClass(ResultSet rs) throws Exception {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setAddress(rs.getString("address"));
        user.setCellphone(rs.getString("cellphone"));
        user.setUsername(rs.getString("username"));
        user.setCourseInfo(rs.getString("courseInfo"));
        user.setSkillInfo(rs.getString("skillInfo"));
        user.setEmail(rs.getString("email"));
        user.setEducation(rs.getString("education"));
        user.setMajor(rs.getString("major"));
        user.setSchool(rs.getString("school"));
        user.setSelfEvaluation(rs.getString("selfEvaluation"));
        user.setEduDate(rs.getString("eduDate"));
        user.setWorkExperience(rs.getString("workExperience"));
        user.setJob(rs.getString("job"));
        user.setPhoto(rs.getString("photo"));
        return user;
    }
}
