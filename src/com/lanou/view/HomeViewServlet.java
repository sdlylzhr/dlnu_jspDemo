package com.lanou.view;

import com.lanou.bean.User;
import com.lanou.dao.UserDao;
import com.lanou.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 页面导航类
 */
@WebServlet(name = "HomeViewServlet", urlPatterns = "/home")
public class HomeViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 从数据库获取所有的用户数据
        // 获取数据库中的所有用户的信息
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JdbcUtils.release(connection,st,resultSet);
        }
        // 将所有的用户数据添加到request域中，转发给jsp文件
        request.setAttribute("uList", list);
        request.getRequestDispatcher("/WEB-INF/pages/homePage.jsp").forward(request,response);
    }
}
