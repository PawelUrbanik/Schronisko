package pl.pawel.schronisko.controller;

import pl.pawel.schronisko.model.User;
import pl.pawel.schronisko.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String submitValue = request.getParameter("submitValue");
        if ("delete".equals(submitValue))
        {
            Long key = Long.parseLong(request.getParameter("userId"));
            UserService userService = new UserService();
            userService.deleteUserById(key);
        }

        response.sendRedirect(request.getContextPath()+"/deleteUser");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    saveUsersInRequest(request);
        System.out.println(request.getAttribute("users"));
    request.getRequestDispatcher("WEB-INF/deleteUser.jsp").forward(request,response);
    }

    private void saveUsersInRequest(HttpServletRequest request) {
        UserService userService = new UserService();
        List<User> users = userService.getAllUsers();
        request.setAttribute("users", users);
     }
}
