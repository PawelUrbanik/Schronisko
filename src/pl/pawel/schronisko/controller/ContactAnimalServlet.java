package pl.pawel.schronisko.controller;

import pl.pawel.schronisko.model.Animal;
import pl.pawel.schronisko.model.ContactAnimal;
import pl.pawel.schronisko.service.AnimalService;
import pl.pawel.schronisko.service.ContactAnimalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contactAnimal")
public class ContactAnimalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long animalId = Long.valueOf(request.getParameter("animalId"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        //System.out.println(name + " " + surname + " " + email + " " + message + " id: " + request.getParameter("animalId"));
        ContactAnimalService contactAnimalService = new ContactAnimalService();
        contactAnimalService.addContactAnimal(animalId,name, surname, email, message);
        response.sendRedirect(request.getContextPath() + "/");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        saveAnimalInRequest(request);
        System.out.println(request.getAttribute("animal"));
        request.getRequestDispatcher("WEB-INF/contactAnimal.jsp").forward(request,response);
    }


    private void saveAnimalInRequest(HttpServletRequest request) {
        Animal animal = new Animal();
        AnimalService animalService = new AnimalService();
        Long animalId = Long.parseLong(request.getParameter("animalId"));
        animal = animalService.getAnimalById(animalId);
        request.setAttribute("animal", animal);
    }
}
