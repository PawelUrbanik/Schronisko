package pl.pawel.schronisko.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.pawel.schronisko.model.User;
import pl.pawel.schronisko.util.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final String CREATE_USER ="INSERT INTO user(username, firstname, lastname, email, password) VALUES(" +
            ":username, :firstname, :lastname, :email, :password);";
    private static final String READ_USER ="SELECT userId, username, firstname, lastname, email, password FROM user " +
            "WHERE userId =:userId;" ;
    private static final String READ_USER_BY_USERNAME = "SELECT userId, username, firstname, lastname, email, password FROM user WHERE username = :username ;";
    private static final String READ_PRIVIGILES = "SELECT role_name FROM user_role WHERE username = :username ;";
    private static final  String DELETE_BY_ID = "DELETE FROM user WHERE user.userId=:userId;";
    private static final String GET_ALL_USERS = "SELECT * FROM user;";

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
            setPrivigiles(newUser, 0);
            
        }
        return newUser;
    }

    private void setPrivigiles(User user, int type) {
          final String  userRoleQuery = "INSERT INTO user_role(username) VALUES(:username);";

        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        template.update(userRoleQuery, parameterSource);
    }
    public User addStaff(User user)
    {
        User newStaff = new User(user);
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        int update = template.update(CREATE_USER, parameterSource, holder);
        if (update >0 )
        {
            newStaff.setId((Long) holder.getKey());
            setPrivigilesStaff(newStaff);
        }
        return newStaff;
    }

    private void setPrivigilesStaff(User user)
    {
        System.out.println("staff");
        final String userRoleQuery = "INSERT INTO user_role(role_name, username) VALUES( 'staff' , :username);";
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        template.update(userRoleQuery,parameterSource);
    }
/*********************************************************************************************************/
    @Override
    public String getPrivigiles(String username) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("username", username);
        String privigiles = template.queryForObject(READ_PRIVIGILES,parameterSource, new PrivigilesRowMapper());
        System.out.println(privigiles);
        return privigiles;
    }
    @Override
    public User read(Long primaryKey) {
        User resultUser = null;
        SqlParameterSource parameterSource = new MapSqlParameterSource("userId", primaryKey);
        resultUser = template.queryForObject(READ_USER, parameterSource, new UserRowMapper());
        return resultUser;
    }

    public User getUserByUsername(String username)
    {
        User resultUser = new User();
        SqlParameterSource parameterSource = new MapSqlParameterSource("username", username);
        resultUser = template.queryForObject(READ_USER_BY_USERNAME, parameterSource, new UserRowMapper());
        return resultUser;
    }


    @Override
    public boolean update(User updatedObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("userId", key);
        int rowDeleted = template.update(DELETE_BY_ID, parameterSource);
        if (rowDeleted < 0) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public List<User> getAll() {
        List<User> users = template.query(GET_ALL_USERS,new UserRowMapper());
        return users;
    }
    private class UserRowMapper implements RowMapper<User>
    {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("userId"));
            user.setUsername(resultSet.getString("username"));
            user.setFirstname(resultSet.getString("firstname"));
            user.setLastname(resultSet.getString("lastname"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
    }
    private class PrivigilesRowMapper implements  RowMapper<String>
    {

        @Override
        public String mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getString("role_name");
        }
    }
}
