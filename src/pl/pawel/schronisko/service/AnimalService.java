package pl.pawel.schronisko.service;

import pl.pawel.schronisko.dao.AnimalDAO;
import pl.pawel.schronisko.dao.DAOFactory;
import pl.pawel.schronisko.model.Animal;
import pl.pawel.schronisko.model.AnimalSex;
import pl.pawel.schronisko.model.AnimalType;

import java.util.List;

public class AnimalService {
    public void addAnimal(String name, String description, int age, String sex, String type, String photo)
    {
        Animal animal = new Animal();
        animal.setName(name);
        animal.setDescription(description);
        animal.setAge(age);
        if (sex.equals("male"))
        animal.setAnimalSex(AnimalSex.MEN);
        else if (sex.equals("female"))
        {
            animal.setAnimalSex(AnimalSex.WOMEN);
        }
        if (type.equals("cat"))
        {
            animal.setAnimalType(AnimalType.CAT);
        }
        else if (type.equals("dog"))
        {
            animal.setAnimalType(AnimalType.DOG);
        }
        else
        {
            animal.setAnimalType(AnimalType.OTHER);
        }
        animal.setAnimalPhoto(photo);
        DAOFactory factory = DAOFactory.getDAOFactory();
        AnimalDAO animalDAO = factory.getAnimalDAO();
        animalDAO.create(animal);
    }

    public List<Animal> getAllAnimal()
    {
        DAOFactory factory = DAOFactory.getDAOFactory();
        AnimalDAO animalDAO = factory.getAnimalDAO();
        List<Animal> animals = animalDAO.getAll();
        return animals;
    }

    public Animal getAnimalById(Long key)
    {
        DAOFactory factory = DAOFactory.getDAOFactory();
        AnimalDAO animalDAO = factory.getAnimalDAO();
        Animal animal = new Animal();
        animal = animalDAO.read(key);
        return animal;
    }

    public  void deleteAnimalById(Long key)
    {
        DAOFactory factory = DAOFactory.getDAOFactory();
        AnimalDAO animalDAO = factory.getAnimalDAO();
        boolean rowsupdated = animalDAO.delete(key);
        System.out.println(rowsupdated);
    }
}
