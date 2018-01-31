package pl.pawel.schronisko.model;

public class Animal {
    private long animalId;
    private String name;
    private String description;
    private int age;
    private AnimalSex animalSex;
    private  AnimalType animalType;
    private String animalPhoto;

    public Animal() {
    }

    public Animal(Animal animal)
    {
        this.setAnimalId(animal.getAnimalId());
        this.setName(animal.getName());
        this.setDescription(animal.getDescription());
        this.setAge(animal.getAge());
        this.setAnimalSex(animal.getAnimalSex());
        this.setAnimalType(animal.getAnimalType());
        this.setAnimalPhoto(animal.getAnimalPhoto());
    }

    public Animal(long animalId, String name, String description, int age, AnimalSex animalSex, AnimalType animalType, String animalPhoto) {
        this.animalId = animalId;
        this.name = name;
        this.description = description;
        this.age = age;
        this.animalSex = animalSex;
        this.animalType = animalType;
        this.animalPhoto = animalPhoto;
    }

    public long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(long animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AnimalSex getAnimalSex() {
        return animalSex;
    }

    public void setAnimalSex(AnimalSex animalSex) {
        this.animalSex = animalSex;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public String getAnimalPhoto() {
        return animalPhoto;
    }

    public void setAnimalPhoto(String animalPhoto) {
        this.animalPhoto = animalPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (animalId != animal.animalId) return false;
        if (age != animal.age) return false;
        if (name != null ? !name.equals(animal.name) : animal.name != null) return false;
        if (description != null ? !description.equals(animal.description) : animal.description != null) return false;
        if (animalSex != animal.animalSex) return false;
        return animalType == animal.animalType;
    }

    @Override
    public int hashCode() {
        int result = (int) (animalId ^ (animalId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (animalSex != null ? animalSex.hashCode() : 0);
        result = 31 * result + (animalType != null ? animalType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                ", animalSex=" + animalSex +
                ", animalType=" + animalType +
                '}';
    }
}
