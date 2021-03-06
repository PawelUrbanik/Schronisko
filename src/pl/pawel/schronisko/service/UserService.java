package pl.pawel.schronisko.service;

import pl.pawel.schronisko.dao.DAOFactory;
import pl.pawel.schronisko.dao.UserDAO;
import pl.pawel.schronisko.model.User;

import java.util.List;

public class UserService {
    public void addUser(String username, String firstname, String lastname, String email, String password)
    {
        User user = setUserProperties(username, firstname, lastname, email, password);
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        userDAO.create(user);
    }

    public void addStaff(String username, String firstname, String lastname, String email, String password)
    {
        User user = setUserProperties(username, firstname, lastname, email, password);
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        UserDAO userDAO = daoFactory.getUserDAO();
        userDAO.addStaff(user);
    }

    private User setUserProperties(String username, String firstname, String lastname, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

    public String getPrivigiles(String username)
    {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
         return userDAO.getPrivigiles(username);
    }


    public User getUserById(long id)
    {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user =  userDAO.read(id);
        return user;
    }

    public User getUserByUsername(String username)
    {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.getUserByUsername(username);
        return user;
    }

    public void deleteUserById(Long userId)
    {
        DAOFactory factory =DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.delete(userId);
    }
    public List<User> getAllUsers()
    {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        List<User> users = userDAO.getAll();
        return users;
    }
}
