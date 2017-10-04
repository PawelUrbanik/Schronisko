package pl.pawel.schronisko.controller;

import pl.pawel.schronisko.util.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataSource dataSource = ConnectionProvider.getDataSource();
        System.out.println(dataSource);
    request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }
}
