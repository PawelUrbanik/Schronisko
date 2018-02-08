package pl.pawel.schronisko.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.pawel.schronisko.model.Animal;
import pl.pawel.schronisko.model.AnimalSex;
import pl.pawel.schronisko.model.AnimalType;
import pl.pawel.schronisko.model.ContactAnimal;
import pl.pawel.schronisko.util.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactAnimalDAOImpl implements ContactAnimalDAO {

    private static final String CREATE_CONTACT = "INSERT INTO  contactanimal ( animalId, username, surname, email, message) VALUES ( :animalId, " +
            ":username, :surname, :email, :message);";
    private static final String GET_ALL = "SELECT animal.animalId, id, username, surname, email, message, animal.animalName, animal.animalDescription, " +
            "animal.animalAge, animal.animalSex, animal.animalType, animal.animalPhoto FROM contactanimal LEFT JOIN " +
            "animal ON contactanimal.animalId=animal.animalId;";
    private NamedParameterJdbcTemplate template;

    public ContactAnimalDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }


    @Override
    public ContactAnimal create(ContactAnimal contactAnimal) {
        ContactAnimal newContact = new ContactAnimal(contactAnimal);
        System.out.println("new contact: id: " + newContact.getAnimal().getAnimalId()+  " name: " + newContact.getUsername() + " surname: " + newContact.getSurname() );

        Map<String, Object> mapParam = new HashMap<>();
        mapParam.put("animalId", newContact.getAnimal().getAnimalId());
        mapParam.put("username", newContact.getUsername());
        mapParam.put("surname", newContact.getSurname());
        mapParam.put("email", newContact.getEmail());
        mapParam.put("message", newContact.getMessage());
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new MapSqlParameterSource(mapParam);
        int updatedRows = template.update(CREATE_CONTACT, parameterSource,holder);
        if (updatedRows > 0)
        {
            newContact.setId((Long) holder.getKey());
        }
        return newContact;
    }

    @Override
    public ContactAnimal read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(ContactAnimal updatedObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    @Override
    public List<ContactAnimal> getAll() {
        List<ContactAnimal> contactAnimals = template.query(GET_ALL, new ContactAnimalRowMapper());
        return contactAnimals;
    }

    private class ContactAnimalRowMapper implements RowMapper<ContactAnimal>{

        @Override
        public ContactAnimal mapRow(ResultSet resultSet, int i) throws SQLException {
            ContactAnimal contactAnimal = new ContactAnimal();
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
            animal.setAnimalPhoto(resultSet.getString("animalPhoto"));

            contactAnimal.setAnimal(animal);

            contactAnimal.setId(resultSet.getLong("id"));
            contactAnimal.setUsername(resultSet.getString("username"));
            contactAnimal.setSurname(resultSet.getString("surname"));
            contactAnimal.setEmail(resultSet.getString("email"));
            contactAnimal.setMessage(resultSet.getString("message"));
            return contactAnimal;
        }
    }
}
