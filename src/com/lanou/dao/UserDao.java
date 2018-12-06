package com.lanou.dao;

import com.lanou.utils.JdbcUtils;
import com.lanou.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库操作类
 */
public class UserDao {

    // 获取数据库中的所有用户的信息
    public List<User> getAllUsers(){

        List<User> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getConnection();
            st = connection.prepareStatement("select * from user");
            resultSet = st.executeQuery();

            // 按顺序读取所有的用户信息
            while (resultSet.next()){
                User user = new User();

                // 把每行数据保存到一个user对象中
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAddress(resultSet.getString("address"));
                user.setBirthday(resultSet.getString("birthday"));

                // 最终结果把所有的user对象保存到一个list容器中。
                list.add(user);
            }

            // 通过方法返回给调用者
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JdbcUtils.release(connection,st,resultSet);
        }
        return list;
    }

}
