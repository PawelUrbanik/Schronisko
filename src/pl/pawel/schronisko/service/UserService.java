package pl.pawel.schronisko.service;

import pl.pawel.schronisko.dao.DAOFactory;
import pl.pawel.schronisko.dao.UserDAO;
import pl.pawel.schronisko.model.User;

public class UserService {
    public void addUser(String username, String firstname, String lastname, String email, String password)
    {
        User user = new User();
        user.setUsername(username);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(password);
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        userDAO.create(user);
    }
}
