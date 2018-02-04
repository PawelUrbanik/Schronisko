package pl.pawel.schronisko.model;

import java.util.Objects;

public class ContactAnimal extends Contact {
    private long AnimalId;

    public ContactAnimal() {
    }

    public ContactAnimal(ContactAnimal contactAnimal) {
        this.setAnimalId(contactAnimal.getAnimalId());
        this.setUsername(contactAnimal.getUsername());
        this.setSurname(contactAnimal.getSurname());
        this.setEmail(contactAnimal.getEmail());
        this.setMessage(contactAnimal.getMessage());
    }

    public ContactAnimal(long animalId) {
        AnimalId = animalId;
    }

    public ContactAnimal(Contact contact, long animalId) {
        super(contact);
        AnimalId = animalId;
    }

    public ContactAnimal(String username, String surname, String email, String message, long animalId) {
        super(username, surname, email, message);
        AnimalId = animalId;
    }

    public long getAnimalId() {
        return AnimalId;
    }

    public void setAnimalId(long animalId) {
        AnimalId = animalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactAnimal that = (ContactAnimal) o;
        return AnimalId == that.AnimalId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(AnimalId);
    }

    @Override
    public String toString() {
        return "ContactAnimal{" +
                "AnimalId=" + AnimalId +
                '}';
    }
}
