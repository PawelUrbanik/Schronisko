package pl.pawel.schronisko.dao;

import pl.pawel.schronisko.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {
    List<User> getAll();

    User getUserByUsername(String username);
}
