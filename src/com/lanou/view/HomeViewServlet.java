package com.lanou.view;

import com.lanou.bean.User;
import com.lanou.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        UserDao userDao = new UserDao();
        List<User> userList = userDao.getAllUsers();

        // 将所有的用户数据添加到request域中，转发给jsp文件
        request.setAttribute("uList", userList);
        request.getRequestDispatcher("/WEB-INF/pages/homePage.jsp").forward(request,response);
    }
}
