package pl.pawel.schronisko.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.pawel.schronisko.model.Animal;
import pl.pawel.schronisko.util.ConnectionProvider;

import java.util.List;

public class AnimalDAOImpl implements AnimalDAO {

    private static final String CREATE_ANIMAL ="INSERT INTO animal (animalName, animalDescription, animalAge, animalSex, animalType) VALUES(" +
            " :name, :description, :age, :animalSex, :animalType);";

    private NamedParameterJdbcTemplate template;

    public AnimalDAOImpl() { template= new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());}


    @Override
    public Animal create(Animal animal)
    {
        Animal newAnimal = new Animal(animal);
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(animal);
        int updateRows = template.update(CREATE_ANIMAL, parameterSource, holder);
        if (updateRows >0)
        {
            newAnimal.setAnimalId((Long) holder.getKey());
        }
        return newAnimal;
    }

    @Override
    public Animal read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(Animal updatedObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    @Override
    public List<Animal> getAll() {
        return null;
    }
}
