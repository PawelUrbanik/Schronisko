package pl.pawel.schronisko.dao;

import pl.pawel.schronisko.model.Animal;

import java.util.List;

public interface AnimalDAO extends GenericDAO<Animal, Long> {
    List<Animal> getAll();
}
