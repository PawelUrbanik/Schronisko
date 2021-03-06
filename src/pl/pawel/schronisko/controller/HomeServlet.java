package pl.pawel.schronisko.controller;

import pl.pawel.schronisko.model.Animal;
import pl.pawel.schronisko.model.Contact;
import pl.pawel.schronisko.service.AnimalService;
import pl.pawel.schronisko.service.ContactService;
import pl.pawel.schronisko.util.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ContactService contactService = new ContactService();
//        List<Contact> contacts = contactService.getAllContacts();
//        request.setAttribute("contacts", contacts);
//        System.out.println(request.getAttribute("contacts"));
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }

}
