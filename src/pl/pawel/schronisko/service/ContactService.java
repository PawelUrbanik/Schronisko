package pl.pawel.schronisko.service;

import pl.pawel.schronisko.dao.ContactDAO;
import pl.pawel.schronisko.dao.DAOFactory;
import pl.pawel.schronisko.model.Contact;

import java.util.List;

public class ContactService {

    public void addContact(String name, String surname, String email, String message)
    {
        Contact contact = new Contact();
        contact.setUsername(name);
        contact.setSurname(surname);
        contact.setEmail(email);
        contact.setMessage(message);

        DAOFactory factory = DAOFactory.getDAOFactory();
        ContactDAO contactDAO = factory.getContactDAO();
        contactDAO.create(contact);
    }

    public List<Contact> getAllContacts()
    {
        DAOFactory factory = DAOFactory.getDAOFactory();
        ContactDAO contactDAO = factory.getContactDAO();
        List<Contact> contacts = contactDAO.getAll();
        return contacts;
    }
}
