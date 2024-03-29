package com.example.todo.servlet;

import com.example.todo.manager.ToDoManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteToDoServlet extends HttpServlet {
   private final ToDoManager toDoManager = new ToDoManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        toDoManager.deleteToDo(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("/home");
    }
}
