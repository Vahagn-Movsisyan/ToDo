<%@ page import="com.example.todo.model.ToDo" %>
<%@ page import="com.example.todo.model.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%ToDo toDoById = (ToDo) request.getAttribute("toDoById");%>
    <title><%=toDoById.getTitle()%>></title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="row bg-white rounded shadow-sm p-2 add-todo-wrapper align-items-center justify-content-center">
    <form action="/update" method="post">
        <div class="col">
            <input type="hidden" name="toDoId" value="<%= toDoById.getId()%>">
            <input class="form-control form-control-lg border-0 add-todo-input bg-transparent rounded"
                   type="text" placeholder="Add new .." name="title" value="<%=toDoById.getTitle()%>">
        </div>
        <div class="col-auto m-0 px-2 d-flex align-items-center">
            <label class="text-secondary my-2 p-0 px-1 view-opt-label due-date-label d-none">Due date not
                set</label>
            <input class="form-control form-control-lg border-0 add-todo-input bg-transparent rounded"
                   type="date" placeholder="Finish date .." name="finishDate" value="<%=toDoById.getFinishDate()%>">
        </div>
        <div>
            <div>
                <select name="statusName">
                    <% for (Status status : Status.values()) { %>
                    <option value="<%= status.name() %>" <%= toDoById.getStatus() == status ? "selected" : "" %>>
                        <%= status %>
                    </option>
                    <% } %>
                </select>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
