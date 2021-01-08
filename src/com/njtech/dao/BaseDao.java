package com.njtech.dao;

import com.njtech.utils.DataSourceUtil;
import java.sql.*;

public abstract class BaseDao {

    protected Connection connection;
    protected PreparedStatement pstm;

    /**
     * 执行增删改操作
     *
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql, Object[] params) throws Exception {
        int updateRows = 0;
        try {
            this.connection = DataSourceUtil.openConnection();
            pstm = connection.prepareStatement(sql); //预编译sql语句，与普通sql的区别：1.编译好了，参数化，防止sql注入；2.第二次执行快
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < params.length; i++) {
                pstm.setObject(i + 1, params[i]);
                sb.append(i+1);
                sb.append("-");
                sb.append(params[i]);
                sb.append(" ");
            }
            System.out.println("params:"+sb.toString());
            updateRows = pstm.executeUpdate();
            return updateRows;
        } catch (Exception e) {
            System.out.println(e.getMessage()+"\n"+e.getCause());
            throw e;
        }
    }

    /**
     * 新增操作
     *
     * @param sql
     * @param params
     * @return 新增的数据主键
     */
    public int executeInsert(String sql, Object[] params) throws Exception {
        Long id = 0L;
        try {
            this.connection = DataSourceUtil.openConnection();
            pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < params.length; i++) {
                pstm.setObject(i + 1, params[i]);
            }
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
            return id.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 查询操作
     *
     * @param sql
     * @param params
     * @return
     */
    public ResultSet executeQuery(String sql, Object[] params) throws Exception {
        ResultSet rs = null;
        try {
            this.connection = DataSourceUtil.openConnection();
            pstm = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstm.setObject(i + 1, params[i]);
            }
            rs = pstm.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return rs;
    }


    /**
     * 释放资源
     *
     * @param reSet
     * @return
     */
    public boolean closeResource(ResultSet reSet) {
        if (reSet != null) {
            try {
                reSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * ResultSet转javaBean
     *
     * @param rs
     * @return
     * @throws Exception
     */
    public abstract Object tableToClass(ResultSet rs) throws Exception;

}
