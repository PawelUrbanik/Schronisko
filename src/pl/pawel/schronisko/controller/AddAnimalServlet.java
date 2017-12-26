package pl.pawel.schronisko.controller;

import pl.pawel.schronisko.service.AnimalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addAnimal")
public class AddAnimalServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/addAniaml.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("inputName");
        String description = request.getParameter("inputDescription");
        int age = Integer.parseInt(request.getParameter("inputAge"));
        String sex = request.getParameter("inputGender");
        String type = request.getParameter("inputType");
        AnimalService animalService = new AnimalService();
        animalService.addAnimal(name,description,age,sex,type);
        response.sendRedirect(request.getContextPath()+"/");
    }


}
