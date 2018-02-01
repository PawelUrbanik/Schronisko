package pl.pawel.schronisko.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.pawel.schronisko.model.Contact;
import pl.pawel.schronisko.util.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactDAOImpl implements ContactDAO {

    private static final String CREATE_CONTACT = "INSERT INTO Contact(name, surname, email, message ) VALUES ( :name, :surname, :email, :message);";
    private static final String GET_ALL = "SELECT * FROM contact;";
    private NamedParameterJdbcTemplate template;

    public ContactDAOImpl() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public Contact create(Contact contact) {
        Contact newContact = new Contact(contact);
        Map<String, Object> mapParam = new HashMap<>();
        mapParam.put("name", newContact.getUsername());
        mapParam.put("surname", newContact.getSurname());
        mapParam.put("email", newContact.getEmail());
        mapParam.put("message", newContact.getMessage());
        KeyHolder  holder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new MapSqlParameterSource(mapParam);
        int updatedRows = template.update(CREATE_CONTACT,parameterSource, holder);
        if (updatedRows >0)
        {
            newContact.setId((Long) holder.getKey());
        }
        return newContact;
    }

    @Override
    public Contact read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(Contact updatedObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    @Override
    public List<Contact> getAll() {
        List<Contact> contacts = template.query(GET_ALL, new ContactRowMapper());
        return contacts;
    }

    private class ContactRowMapper implements RowMapper<Contact>
    {

        @Override
        public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setUsername(resultSet.getString("name"));
            contact.setSurname(resultSet.getString("surname"));
            contact.setEmail(resultSet.getString("email"));
            contact.setMessage(resultSet.getString("message"));
            return contact;
        }
    }

}
