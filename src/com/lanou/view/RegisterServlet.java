package com.lanou.view;

import com.lanou.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/reg")
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String repwd = request.getParameter("repwd");

        if (pwd.equals(repwd)) {

            try {
                Connection connection = JdbcUtils.getConnection();

                PreparedStatement st = connection.prepareStatement("insert into user(username,password) values (?,?)");

                st.setString(1, uname);
                st.setString(2, pwd);

                int result = st.executeUpdate();

                if (result > 0){
                    System.out.println("注册成功");

                    response.sendRedirect("/loginview");
                }


            } catch (SQLException e) {
                e.printStackTrace();

                request.setAttribute("msg","注册失败，用户名重复");
                request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
            }
        } else {
            System.out.println("注册失败");

            request.setAttribute("msg","注册失败，密码不匹配");
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);

        }


    }
}
