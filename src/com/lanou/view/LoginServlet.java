package com.lanou.view;

import com.lanou.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("uname");
        String password = request.getParameter("pwd");

        try {
            Connection connection = JdbcUtils.getConnection();

            PreparedStatement st = connection.prepareStatement("select * from user where username = ? and password = ?");

            st.setString(1, uname);
            st.setString(2, password);

            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()){
                System.out.println("登录成功！");
                // 保存用户信息
                HttpSession session = request.getSession();
                session.setAttribute("username", uname);
                response.sendRedirect("/home");
            } else {
                System.out.println("登录失败！用户名或密码错误");
                request.setAttribute("msg","用户名或密码错误");
                request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
