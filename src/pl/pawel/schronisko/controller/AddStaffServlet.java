package pl.pawel.schronisko.controller;

import pl.pawel.schronisko.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStaff")
public class AddStaffServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/addStaff.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String firstname = request.getParameter("inputFirstName");
        String lastname = request.getParameter("inputLastname");
        String email = request.getParameter("inputEmail");
        String username = request.getParameter("inputUsername");
        String password = request.getParameter("inputPassword");
        UserService userService = new UserService();
        userService.addStaff(username,firstname,lastname,email,password);
        response.sendRedirect(request.getContextPath()+"/");
    }
}
