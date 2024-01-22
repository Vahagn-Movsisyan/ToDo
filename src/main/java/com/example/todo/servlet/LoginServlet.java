package com.example.todo.servlet;

import com.example.todo.manager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final UserManager userManager = new UserManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (userManager.getUserByEmail(email) != null && password.equals(userManager.getUserByEmail(email).getPassword())) {
            req.getSession().setAttribute("user", userManager.getUserByEmail(email));
            resp.sendRedirect("/home");
        } else {
            req.getSession().setAttribute("msg", "Invalid Email or Password");
            req.getRequestDispatcher("/app").forward(req, resp);
        }
    }
}
