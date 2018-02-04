package pl.pawel.schronisko.dao;

import pl.pawel.schronisko.model.ContactAnimal;

import java.util.List;

public interface ContactAnimalDAO extends GenericDAO<ContactAnimal, Long> {
    List<ContactAnimal> getAll();
}
