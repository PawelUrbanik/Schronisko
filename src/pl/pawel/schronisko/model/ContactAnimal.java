package pl.pawel.schronisko.model;

import java.util.Objects;

public class ContactAnimal extends Contact {
    private Animal animal;

    public ContactAnimal() {
    }

    public ContactAnimal(ContactAnimal contactAnimal) {
        this.setAnimal(contactAnimal.getAnimal());
        this.setUsername(contactAnimal.getUsername());
        this.setSurname(contactAnimal.getSurname());
        this.setEmail(contactAnimal.getEmail());
        this.setMessage(contactAnimal.getMessage());
    }

    public ContactAnimal(Animal animal) { this.animal = animal;
    }

    public ContactAnimal(Contact contact, Animal animal) {
        super(contact);
        this.animal = animal;
    }

    public ContactAnimal(String username, String surname, String email, String message, Animal animal) {
        super(username, surname, email, message);
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactAnimal that = (ContactAnimal) o;
        return Objects.equals(animal, that.animal);
    }

    @Override
    public int hashCode() {

        return Objects.hash(animal);
    }

    @Override
    public String toString() {
        return "ContactAnimal{" +
                "animal=" + animal + ") id: "+ this.getId() + " username: "+ this.getUsername()+ " Surname: " + this.getSurname() +
                " email: "+ this.getEmail()+ " message: " + this.getMessage() ;
    }
}
