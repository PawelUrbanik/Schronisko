package pl.pawel.schronisko.model;

public class Contact {
    private long id;
    private String username;
    private String surname;
    private String email;
    private String message;

    public Contact() {
    }

    public Contact(Contact contact) {
        this.setId(contact.getId());
        this.setUsername(contact.getUsername());
        this.setSurname(contact.getSurname());
        this.setEmail(contact.getEmail());
        this.setMessage(contact.getMessage());
    }


    public long getId() {
        return id;
    }

    public Contact(String username, String surname, String email, String message) {
        this.username = username;
        this.surname = surname;
        this.email = email;
        this.message = message;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
