package com.example.todo.servlet;

import com.example.todo.manager.ToDoManager;
import com.example.todo.manager.UserManager;
import com.example.todo.model.Status;
import com.example.todo.model.ToDo;
import com.example.todo.model.User;
import com.example.todo.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(urlPatterns = "/add")
public class AddToDoServlet extends HttpServlet {
    ToDoManager toDoManager = new ToDoManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            toDoManager.addToDo(ToDo.builder()
                    .title(req.getParameter("title"))
                    .createdDate(new Date())
                    .finishDate(DateUtil.stringToDate(req.getParameter("finishDate")))
                    .user((User) req.getSession().getAttribute("user"))
                    .status(Status.NEW)
                    .build());
            resp.sendRedirect("/home");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
