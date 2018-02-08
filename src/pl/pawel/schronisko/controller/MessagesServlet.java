package pl.pawel.schronisko.controller;

import pl.pawel.schronisko.model.ContactAnimal;
import pl.pawel.schronisko.service.ContactAnimalService;
import pl.pawel.schronisko.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/messages")
public class MessagesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String submitValue = request.getParameter("submitValue");
        if ("delete".equals(submitValue))
        {
            Long key = Long.parseLong(request.getParameter("id"));
            ContactAnimalService contactAnimalService = new ContactAnimalService();
            contactAnimalService.
        }

        response.sendRedirect(request.getContextPath()+"/deleteUser");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        saveContactAnimalInReq(request);
        System.out.println(request.getAttribute("contactAnimals"));
        request.getRequestDispatcher("WEB-INF/Messages.jsp").forward(request,response);
    }

    private void saveContactAnimalInReq(HttpServletRequest request) {
        ContactAnimalService contactAnimalService = new ContactAnimalService();
        List<ContactAnimal> contactAnimals = contactAnimalService.getAllContacts();
        request.setAttribute("contactAnimals", contactAnimals);
    }
}
