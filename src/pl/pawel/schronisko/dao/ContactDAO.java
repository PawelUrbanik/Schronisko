package pl.pawel.schronisko.dao;

import pl.pawel.schronisko.model.Contact;

import java.util.List;

public interface ContactDAO extends GenericDAO<Contact, Long> {

    List<Contact> getAll();
}
