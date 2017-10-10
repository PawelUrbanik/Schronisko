package pl.pawel.schronisko.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.pawel.schronisko.model.Animal;
import pl.pawel.schronisko.model.AnimalSex;
import pl.pawel.schronisko.model.AnimalType;
import pl.pawel.schronisko.util.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalDAOImpl implements AnimalDAO {

    private static final String CREATE_ANIMAL ="INSERT INTO animal (animalName, animalDescription, animalAge, animalSex, animalType) VALUES(" +
            " :name, :description, :age, :animalSex, :animalType);";
    private static final String GET_ALL_ANIMAL="SELECT * FROM animal;";
    private NamedParameterJdbcTemplate template;

    public AnimalDAOImpl() { template= new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());}


    @Override
    public Animal create(Animal animal)
    {
        Animal newAnimal = new Animal(animal);
        Map<String, Object> mapParam = new HashMap<>();
        mapParam.put("name", newAnimal.getName());
        mapParam.put("description", newAnimal.getDescription());
        mapParam.put("age", newAnimal.getAge());
        mapParam.put("animalSex", newAnimal.getAnimalSex().toString());
        mapParam.put("animalType", newAnimal.getAnimalType().toString());
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new MapSqlParameterSource(mapParam);
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
    public List<Animal> getAll()
    {
        List<Animal> animals = template.query(GET_ALL_ANIMAL, new AnimalRowMapper());
        return animals;
    }

    private class AnimalRowMapper implements RowMapper<Animal>{
        @Override
        public Animal mapRow(ResultSet resultSet, int i) throws SQLException {
            Animal animal = new Animal();
            animal.setAnimalId(resultSet.getLong("animalId"));
            animal.setName(resultSet.getString("animalName"));
            animal.setDescription(resultSet.getString("animalDescription"));
            animal.setAge(resultSet.getInt("animalAge"));
            String sex = resultSet.getString("animalSex");
            String type = resultSet.getString("animalType");
            switch (sex)
            {
                case "MEN":
                    animal.setAnimalSex(AnimalSex.MEN);
                    break;
                case "WOMEN":
                    animal.setAnimalSex(AnimalSex.WOMEN);
                    break;
            }
            switch (type)
            {
                case "CAT":
                    animal.setAnimalType(AnimalType.CAT);
                    break;
                case "DOG":
                    animal.setAnimalType(AnimalType.DOG);
                    break;
                default:
                    animal.setAnimalType(AnimalType.OTHER);
                    break;
            }
            return animal;
        }
    }
}
