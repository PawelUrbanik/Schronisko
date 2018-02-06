package pl.pawel.schronisko.controller;

import pl.pawel.schronisko.model.Animal;
import pl.pawel.schronisko.service.AnimalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manage")
public class ManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String submitValue = request.getParameter("submitValue");
        if ("delete".equals(submitValue))
        {
            Long key = Long.parseLong(request.getParameter("animalId"));
            AnimalService animalService = new AnimalService();
            animalService.deleteAnimalById(key);
        }

        response.sendRedirect(request.getContextPath()+"/manage");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        saveAnimalsInRequest(request);
        request.getRequestDispatcher(request.getContextPath()+"/WEB-INF/manage.jsp").forward(request,response);
    }

    private void saveAnimalsInRequest(HttpServletRequest request) {
        AnimalService animalService = new AnimalService();
        List<Animal> animals = animalService.getAllAnimal();
        request.setAttribute("animals", animals);
    }
}
