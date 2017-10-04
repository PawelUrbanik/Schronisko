package pl.pawel.schronisko.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.pawel.schronisko.model.User;
import pl.pawel.schronisko.util.ConnectionProvider;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final String CREATE_USER ="INSERT INTO user(username, firstname, lastname, email, password) VALUES(" +
            ":username, :firstname, :lastname, :email, :password);";
    private NamedParameterJdbcTemplate template;

    public UserDAOImpl()
    {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public User create(User user)
    {
        User newUser = new User(user);
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        int update = template.update(CREATE_USER, parameterSource, holder);
        if (update > 0)
        {
            newUser.setId((Long)holder.getKey());
            setPrivigiles(newUser);
            
        }
        return newUser;
    }

    private void setPrivigiles(User user) {
        final String userRoleQuery = "INSERT INTO user_role(username) VALUES(:username);";
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        template.update(userRoleQuery, parameterSource);
    }

    @Override
    public User read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(User updatedObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
