package pl.pawel.schronisko.model;

public class User {
    private long id;
    private String username;
    private String lastName;
    private String email;
    private String password;

    public User() {
    }

    public User(User user)
    {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setLastName(user.getLastName());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
    }

    public User(long id, String username, String lastName, String email, String password) {
        this.id = id;
        this.username = username;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
