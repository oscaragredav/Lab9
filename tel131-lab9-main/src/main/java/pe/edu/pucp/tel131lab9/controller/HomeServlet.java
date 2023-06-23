package pe.edu.pucp.tel131lab9.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pe.edu.pucp.tel131lab9.bean.Employee;
import pe.edu.pucp.tel131lab9.dao.CommentDao;
import pe.edu.pucp.tel131lab9.dao.PostDao;

import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet",""})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view;

        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("userSession");

        PostDao postDao = new PostDao();
        CommentDao commentDao = new CommentDao();

            request.setAttribute("user", employee);
            request.setAttribute("posts", postDao.listPosts());
            request.setAttribute("comments", commentDao.listComments());
            view = request.getRequestDispatcher("home.jsp");
            view.forward(request, response);


    }
}
