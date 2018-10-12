package com.alevel.todos;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/todo")
public class TodoServlet extends HttpServlet {
    private HikariDataSource dataSource;
    private TodoRepository todoRepository;

    @Override
    public void init() throws ServletException {
        HikariConfig hikariConfig = new HikariConfig("/hikary.properties");
        dataSource=new HikariDataSource((hikariConfig));
        todoRepository = new TodoRepository(dataSource);
    }

    @Override
    public void destroy() {
        dataSource.close();
    }
}
