package pl.pawel.schronisko.service;

import pl.pawel.schronisko.dao.ContactAnimalDAO;
import pl.pawel.schronisko.dao.DAOFactory;
import pl.pawel.schronisko.model.ContactAnimal;

import java.util.List;

public class ContactAnimalService {

    public void addContactAnimal(Long animalId, String username, String surname, String email, String message) {
        ContactAnimal contactAnimaal = new ContactAnimal();
        contactAnimaal.setAnimalId(animalId);
        contactAnimaal.setUsername(username);
        contactAnimaal.setSurname(surname);
        contactAnimaal.setEmail(email);
        contactAnimaal.setMessage(message);

        DAOFactory factory = DAOFactory.getDAOFactory();
        ContactAnimalDAO contactAnimalDAO = factory.getContactAnimalDAO();
        contactAnimalDAO.create(contactAnimaal);
    }

    List<ContactAnimal> getAllContacts() {
        DAOFactory factory = DAOFactory.getDAOFactory();
        ContactAnimalDAO contactAnimalDAO = factory.getContactAnimalDAO();
        List<ContactAnimal> contactAnimals = contactAnimalDAO.getAll();
        return contactAnimals;
    }
}
