package com.example.todo.servlet;

import com.example.todo.manager.ToDoManager;
import com.example.todo.model.ToDo;
import com.example.todo.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/sorted-todos-by-date")
public class SortedToDosByDateServlet extends HttpServlet {
    private ToDoManager toDoManager = new ToDoManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<ToDo> toDos = toDoManager.getToDoByUserSortedByDate(user.getId());
        req.setAttribute("todosSort", toDos);
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }
}
