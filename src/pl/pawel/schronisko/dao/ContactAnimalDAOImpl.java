package pl.pawel.schronisko.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
    private static final String GET_ALL = "SELECT * FROM contactanimal;";
    private NamedParameterJdbcTemplate template;

    public ContactAnimalDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }


    @Override
    public ContactAnimal create(ContactAnimal contactAnimal) {
        ContactAnimal newContact = new ContactAnimal(contactAnimal);
        System.out.println("new contact: id: " + newContact.getAnimalId()+  " name: " + newContact.getUsername() + " surname: " + newContact.getSurname() );

        Map<String, Object> mapParam = new HashMap<>();
        mapParam.put("animalId", newContact.getAnimalId());
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
            contactAnimal.setId(resultSet.getLong("id"));
            contactAnimal.setAnimalId(resultSet.getLong("animalId"));
            contactAnimal.setUsername(resultSet.getString("username"));
            contactAnimal.setSurname(resultSet.getString("surname"));
            contactAnimal.setEmail(resultSet.getString("email"));
            contactAnimal.setMessage(resultSet.getString("message"));
            return contactAnimal;
        }
    }
}
